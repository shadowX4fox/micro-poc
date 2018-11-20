package org.shadowx4fox.controller;

import com.hazelcast.core.IMap;
import com.hazelcast.query.EntryObject;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.PredicateBuilder;
import com.hazelcast.query.SqlPredicate;
import io.micronaut.http.annotation.Controller;
import org.shadowx4fox.api.HistoryOperations;
import org.shadowx4fox.api.OperationHistory;
import org.shadowx4fox.hazelcast.HazelcastManager;
import org.shadowx4fox.kafka.OperationRegisteredEvent;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Controller("/history")
public class HistoryController implements HistoryOperations {

    @Inject
    private HazelcastManager hazelcastManager;
    private IMap<Integer, OperationRegisteredEvent> operationResultMap;

    @PostConstruct
    public void init()
    {
        this.operationResultMap = hazelcastManager.getHazelcastInstance().getMap("operationResultMap");
    }


    @Override
    public List<OperationHistory> getLatestOperations(String tag) {

        EntryObject e = new PredicateBuilder().getEntryObject();
        Predicate namePredicate = e.get( "name" ).equal( tag );

        AtomicInteger atomicInteger = new AtomicInteger();

        List<OperationHistory> opList = operationResultMap.values(namePredicate).stream()
                .map(operationRegisteredEvent -> {
                    OperationHistory op = new OperationHistory();
                    op.setId(atomicInteger.getAndIncrement());
                    op.setEvent(operationRegisteredEvent);
                    return op;
                })
                .collect(Collectors.toList());

        opList.sort((o1, o2) -> o1.getEvent().getOrder().compareTo(o2.getEvent().getOrder()));
        return opList;
    }
}
