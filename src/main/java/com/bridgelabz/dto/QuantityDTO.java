package com.bridgelabz.dto;

public class QuantityDTO {

    private double value;
    private String unit;
    private String measurementType;

    // Default constructor
    public QuantityDTO() {}

    // Parameterized constructor
    public QuantityDTO(double value, String unit, String measurementType) {
        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }

    // Getters
    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    // Setters
    public void setValue(double value) {
        this.value = value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }
}