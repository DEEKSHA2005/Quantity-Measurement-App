package com.bridgelabz.entity;

public class QuantityMeasurementEntity {

    private String operation;
    private String result;

    public QuantityMeasurementEntity(String operation, String result) {
        this.operation = operation;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public String getResult() {
        return result;
    }
}