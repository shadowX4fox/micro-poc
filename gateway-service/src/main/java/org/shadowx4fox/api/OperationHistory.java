package org.shadowx4fox.api;

import org.shadowx4fox.kafka.OperationRegisteredEvent;

public class OperationHistory {

    private int id;
    private OperationRegisteredEvent event;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OperationRegisteredEvent getEvent() {
        return event;
    }

    public void setEvent(OperationRegisteredEvent event) {
        this.event = event;
    }

}
