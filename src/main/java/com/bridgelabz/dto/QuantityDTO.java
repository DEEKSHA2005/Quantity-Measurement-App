package com.bridgelabz.dto;

public class QuantityDTO {

    private double value;
    private String unit;
    private String measurementType;

    // Default Constructor
    public QuantityDTO() {
    }

    // Parameterized Constructor
    public QuantityDTO(double value,
                       String unit,
                       String measurementType) {

        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }

    // Getter
    public double getValue() {
        return value;
    }

    // Setter
    public void setValue(double value) {
        this.value = value;
    }

    // Getter
    public String getUnit() {
        return unit;
    }

    // Setter
    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Getter
    public String getMeasurementType() {
        return measurementType;
    }

    // Setter
    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }
}