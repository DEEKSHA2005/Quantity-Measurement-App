package com.bridgelabz;

public class QuantityMeasurementApp {

    // UC1
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

    // UC2
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

    // UC3 + UC5
    public static class Length {

        private final double value;
        private final LengthUnit unit;

        // ENUM for supported units
        public enum LengthUnit {

            INCHES(1.0),          // Base unit
            FEET(12.0),           // 1 foot = 12 inches
            YARDS(36.0),          // 1 yard = 36 inches
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

        // Convert value to base unit (inches)
        private double toBaseUnit() {
            return value * unit.getConversionFactor();
        }

        // Equality check (UC3)
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

        // UC5: Static conversion API
        public static double convert(double value,
                                     LengthUnit source,
                                     LengthUnit target) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid numeric value");
            }

            if (source == null || target == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

            double baseValue = value * source.getConversionFactor();

            return baseValue / target.getConversionFactor();
        }

        // Instance conversion method
        public Length convertTo(LengthUnit target) {

            double convertedValue =
                    convert(this.value, this.unit, target);

            return new Length(convertedValue, target);
        }

        // Better readability
        @Override
        public String toString() {
            return value + " " + unit;
        }
    }
}