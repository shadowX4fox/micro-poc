package org.shadowx4fox.kafka;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class OperationRegisteredEvent implements Serializable {

    private String name;
    private BigDecimal value1;
    private BigDecimal value2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue1() {
        return value1;
    }

    public void setValue1(BigDecimal value1) {
        this.value1 = value1;
    }

    public BigDecimal getValue2() {
        return value2;
    }

    public void setValue2(BigDecimal value2) {
        this.value2 = value2;
    }

}
