package org.shadowx4fox;

import io.micronaut.context.env.Environment;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, Environment.DEVELOPMENT);
    }
}