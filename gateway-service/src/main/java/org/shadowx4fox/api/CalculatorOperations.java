package org.shadowx4fox.api;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.retry.annotation.CircuitBreaker;

import java.math.BigDecimal;

public interface CalculatorOperations {

    @Get("/add")
    @CircuitBreaker(reset = "25s")
    BigDecimal add(@QueryValue(value = "tag")String tag, @QueryValue(value = "value1")BigDecimal value1, @QueryValue(value = "value2")BigDecimal value2);

    @Get("/subtract")
    @CircuitBreaker(reset = "25s")
    BigDecimal subtract(@QueryValue(value = "tag")String tag, @QueryValue(value = "value1")BigDecimal value1, @QueryValue(value = "value2")BigDecimal value2);

    @Get("/multiply")
    @CircuitBreaker(reset = "25s")
    BigDecimal multiply(@QueryValue(value = "tag")String tag, @QueryValue(value = "value1")BigDecimal value1, @QueryValue(value = "value2")BigDecimal value2);

    @Get("/divide")
    @CircuitBreaker(reset = "25s")
    BigDecimal divide(@QueryValue(value = "tag")String tag, @QueryValue(value = "value1")BigDecimal value1, @QueryValue(value = "value2")BigDecimal value2);


}
