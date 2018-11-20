package org.shadowx4fox.api;

import io.micronaut.http.annotation.Get;

import java.util.List;


public interface HistoryOperations {

    @Get("/lastOperations")
    List<OperationHistory> getLatestOperations(String tag);

}
