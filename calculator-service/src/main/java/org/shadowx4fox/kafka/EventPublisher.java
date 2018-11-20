package org.shadowx4fox.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface EventPublisher {

    @Topic("operation-registered")
    void operationRegisteredEvent(@KafkaKey String id, OperationRegisteredEvent event);

}
