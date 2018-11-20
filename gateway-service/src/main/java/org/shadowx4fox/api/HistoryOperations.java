package org.shadowx4fox.api;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.retry.annotation.CircuitBreaker;

import java.util.List;


public interface HistoryOperations {

    @Get("/lastOperations")
    @CircuitBreaker(reset = "25s")
    List<OperationHistory> getLatestOperations(@QueryValue(value = "tag")String tag);

}
