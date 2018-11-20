package org.shadowx4fox.controller;

import io.micronaut.http.annotation.Controller;
import org.shadowx4fox.api.CalculatorOperations;
import org.shadowx4fox.kafka.EventPublisher;
import org.shadowx4fox.kafka.OperationRegisteredEvent;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.UUID;

@Controller("/calculator")
public class CalculatorController implements CalculatorOperations {

    @Inject
    private EventPublisher eventPublisher;

    @Override
    public BigDecimal add(String tag,BigDecimal value1, BigDecimal value2) {
        publishEvent("add",tag,value1,value2);
        return value1.add(value2);
    }

    @Override
    public BigDecimal subtract(String tag, BigDecimal value1, BigDecimal value2) {
        publishEvent("subtract",tag,value1,value2);
        return value1.subtract(value2);
    }

    @Override
    public BigDecimal multiply(String tag,BigDecimal value1, BigDecimal value2) {
        publishEvent("multiply",tag,value1,value2);
        return value1.multiply(value2);
    }

    @Override
    public BigDecimal divide(String tag,BigDecimal value1, BigDecimal value2) {
        publishEvent("divide",tag,value1,value2);
        return value1.divide(value2);
    }

    private void publishEvent(String op,String tag,BigDecimal value1,BigDecimal value2)
    {
        OperationRegisteredEvent operationRegisteredEvent = new OperationRegisteredEvent();
        operationRegisteredEvent.setName(tag);
        operationRegisteredEvent.setValue1(value1);
        operationRegisteredEvent.setValue2(value2);
        eventPublisher.operationRegisteredEvent(op,operationRegisteredEvent);
    }
}
