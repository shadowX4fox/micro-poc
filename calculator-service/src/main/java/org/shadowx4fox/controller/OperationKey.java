package org.shadowx4fox.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class OperationKey implements Serializable {

    private String name;
    private BigDecimal value1;
    private BigDecimal value2;

    public OperationKey(String name,BigDecimal value1,BigDecimal value2)
    {
        this.setName(name);
        this.setValue1(value1);
        this.setValue2(value2);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationKey that = (OperationKey) o;
        return Objects.equals(name,that.name) &&
                Objects.equals(value1, that.value1) &&
                Objects.equals(value2, that.value2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,value1, value2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
