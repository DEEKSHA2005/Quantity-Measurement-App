package com.bridgelabz;

public interface IMeasurable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    boolean supportsArithmetic();

    void validateOperationSupport(String operation);

    String getUnitName();

    double getConversionFactor();

    String getMeasurementType();
}