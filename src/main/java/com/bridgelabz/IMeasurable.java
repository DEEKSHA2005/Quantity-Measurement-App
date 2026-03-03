package com.bridgelabz;

@FunctionalInterface
interface SupportsArithmetic {
    boolean isSupported();
}

public interface IMeasurable {

    double getConversionFactor();
    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);
    String getUnitName();

    // 🔹 Default: All units support arithmetic
    default boolean supportsArithmetic() {
        return true;
    }

    // 🔹 Default: Do nothing (units can override)
    default void validateOperationSupport(String operation) {
        // By default all operations supported
    }
}