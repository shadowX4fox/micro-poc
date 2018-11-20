package org.shadowx4fox.api.client;

import io.micronaut.http.client.annotation.Client;
import org.shadowx4fox.api.CalculatorOperations;

@Client(id = "calculator-service", path = "/calculator")
public interface CalculatorGatewayClient extends CalculatorOperations {
}
