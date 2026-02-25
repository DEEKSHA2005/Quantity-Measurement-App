package com.bridgelabz;

public class QuantityMeasurementApp {

    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }
        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (getClass() != obj.getClass())
                return false;

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }
    public static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (getClass() != obj.getClass())
                return false;

            Inches other = (Inches) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }
    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public enum LengthUnit {

            FEET(12.0),          // 1 foot = 12 inches
            INCHES(1.0),        // base unit
            YARDS(36.0),        // 1 yard = 36 inches
            CENTIMETERS(0.393701); // 1 cm = 0.393701 inches

            private final double conversionFactor;

            LengthUnit(double conversionFactor) {
                this.conversionFactor = conversionFactor;
            }

            public double getConversionFactor() {
                return conversionFactor;
            }
        }

        public Length(double value, LengthUnit unit) {
            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            this.value = value;
            this.unit = unit;
        }

        private double toBaseUnit() {
            return value * unit.getConversionFactor();
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (getClass() != obj.getClass())
                return false;

            Length other = (Length) obj;

            return Double.compare(this.toBaseUnit(),
                    other.toBaseUnit()) == 0;
        }
    }
}