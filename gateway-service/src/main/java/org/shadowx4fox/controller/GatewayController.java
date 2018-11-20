package org.shadowx4fox.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.shadowx4fox.api.OperationHistory;
import org.shadowx4fox.api.client.CalculatorGatewayClient;
import org.shadowx4fox.api.client.HistoryGatewayClient;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

@Controller("/api/digitalCalc")
public class GatewayController {

    @Inject
    private CalculatorGatewayClient calculatorGatewayClient;
    @Inject
    private HistoryGatewayClient historyGatewayClient;

    @Get("/lastOperations")
    public List<OperationHistory> getLatestOperations(String tag)
    {
        return historyGatewayClient.getLatestOperations(tag);
    }

    @Get("/add")
    public BigDecimal add(String tag, BigDecimal value1, BigDecimal value2)
    {
        return calculatorGatewayClient.add(tag,value1,value2);
    }

    @Get("/subtract")
    public BigDecimal subtract(String tag, BigDecimal value1, BigDecimal value2)
    {
        return calculatorGatewayClient.subtract(tag,value1,value2);
    }

    @Get("/multiply")
    public BigDecimal multiply(String tag, BigDecimal value1, BigDecimal value2)
    {
        return calculatorGatewayClient.multiply(tag,value1,value2);
    }

    @Get("/divide")
    public BigDecimal divide(String tag, BigDecimal value1, BigDecimal value2)
    {
        return calculatorGatewayClient.divide(tag,value1,value2);
    }

}
