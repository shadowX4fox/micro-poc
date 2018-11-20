package org.shadowx4fox;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        String jaeger = System.getProperty("JAEGER_REPORTER_LOG_SPANS");
        Micronaut.run(Application.class
        );
    }
}