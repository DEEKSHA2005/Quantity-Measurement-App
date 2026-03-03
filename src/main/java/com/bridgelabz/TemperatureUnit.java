package com.bridgelabz;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS {
        public double convertToBaseUnit(double value) {
            return value; // base
        }

        public double convertFromBaseUnit(double baseValue) {
            return baseValue;
        }
    },

    FAHRENHEIT {
        public double convertToBaseUnit(double value) {
            return (value - 32) * 5.0 / 9.0;
        }

        public double convertFromBaseUnit(double baseValue) {
            return (baseValue * 9.0 / 5.0) + 32;
        }
    },

    KELVIN {
        public double convertToBaseUnit(double value) {
            return value - 273.15;
        }

        public double convertFromBaseUnit(double baseValue) {
            return baseValue + 273.15;
        }
    };

    // 🔹 Temperature does NOT support arithmetic
    @Override
    public boolean supportsArithmetic() {
        return false;
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation + " operation."
        );
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

}
