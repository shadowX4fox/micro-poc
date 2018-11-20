package org.shadowx4fox.api;

import io.micronaut.http.annotation.Get;

import java.math.BigDecimal;

public interface CalculatorOperations {

    @Get("/add")
    BigDecimal add(String tag,BigDecimal value1,BigDecimal value2);

    @Get("/subtract")
    BigDecimal subtract(String tag,BigDecimal value1,BigDecimal value2);

    @Get("/multiply")
    BigDecimal multiply(String tag,BigDecimal value1,BigDecimal value2);

    @Get("/divide")
    BigDecimal divide(String tag,BigDecimal value1,BigDecimal value2);


}
