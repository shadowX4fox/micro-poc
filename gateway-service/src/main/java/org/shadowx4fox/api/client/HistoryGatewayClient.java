package org.shadowx4fox.api.client;

import io.micronaut.http.client.annotation.Client;
import org.shadowx4fox.api.HistoryOperations;

@Client(id = "history-service", path = "/history")
public interface HistoryGatewayClient extends HistoryOperations {
}
