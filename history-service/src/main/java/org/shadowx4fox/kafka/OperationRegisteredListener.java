package org.shadowx4fox.kafka;

import com.hazelcast.core.IMap;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.shadowx4fox.hazelcast.HazelcastManager;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class OperationRegisteredListener {

    @Inject
    private HazelcastManager hazelcastManager;
    private IMap<Integer, OperationRegisteredEvent> operationResultMap;
    private AtomicInteger atomicInteger = new AtomicInteger();

    @PostConstruct
    public void initController()
    {
        this.operationResultMap = this.hazelcastManager.getHazelcastInstance().getMap("operationResultMap");
    }

    @Topic("operation-registered")
    void onOperationRegistered(@KafkaKey String id, OperationRegisteredEvent operationRegisteredEvent)
    {
        operationRegisteredEvent.setOrder(atomicInteger.incrementAndGet());
        operationRegisteredEvent.setOperation(id);
        this.operationResultMap.put(operationRegisteredEvent.getOrder(),operationRegisteredEvent);
        System.out.println(id + " : registry received");
    }

}
