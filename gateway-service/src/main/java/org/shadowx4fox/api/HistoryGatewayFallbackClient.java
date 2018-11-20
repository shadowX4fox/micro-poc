package org.shadowx4fox.api;

import io.micronaut.retry.annotation.Fallback;
import org.shadowx4fox.kafka.OperationRegisteredEvent;

import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Singleton
@Fallback
public class HistoryGatewayFallbackClient implements HistoryOperations {

    @Override
    public List<OperationHistory> getLatestOperations(String tag)
    {
        OperationHistory operationHistory = new OperationHistory();
        operationHistory.setId(0);
        OperationRegisteredEvent operationRegisteredEvent = new OperationRegisteredEvent();
        operationRegisteredEvent.setName("no data");
        operationRegisteredEvent.setValue1(BigDecimal.ZERO);
        operationRegisteredEvent.setValue2(BigDecimal.ZERO);
        operationHistory.setEvent(operationRegisteredEvent);
        return Arrays.asList(new OperationHistory[]{operationHistory});
    }
}
