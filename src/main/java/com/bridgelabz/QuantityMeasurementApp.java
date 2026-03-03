package com.bridgelabz;

public class QuantityMeasurementApp {

    // UC1
    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
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

    // UC3 + UC4 + UC5 + UC6 + UC7
    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {

            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid numeric value");

            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        // Convert to base unit (FEET)
        private double toBaseUnit() {
            return unit.convertToBaseUnit(value);
        }

        // UC3 Equality
        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (getClass() != obj.getClass())
                return false;

            Length other = (Length) obj;

            double difference = Math.abs(this.toBaseUnit() - other.toBaseUnit());

            return difference < 0.0001;
        }

        // UC5 Static conversion
        public static double convert(double value, LengthUnit source, LengthUnit target) {

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid numeric value");

            if (source == null || target == null)
                throw new IllegalArgumentException("Unit cannot be null");

            double baseValue = source.convertToBaseUnit(value);
            return target.convertFromBaseUnit(baseValue);
        }

        // Instance conversion
        public Length convertTo(LengthUnit target) {

            double baseValue = unit.convertToBaseUnit(value);
            double convertedValue = target.convertFromBaseUnit(baseValue);

            return new Length(convertedValue, target);
        }

        // UC6 Addition
        public Length add(Length other) {

            if (other == null)
                throw new IllegalArgumentException("Length cannot be null");

            double base1 = this.toBaseUnit();
            double base2 = other.toBaseUnit();

            double sumBase = base1 + base2;

            double resultValue = unit.convertFromBaseUnit(sumBase);

            return new Length(resultValue, unit);
        }

        // UC7 Addition with target unit
        public Length add(Length other, LengthUnit targetUnit) {

            if (other == null)
                throw new IllegalArgumentException("Length cannot be null");

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double base1 = this.toBaseUnit();
            double base2 = other.toBaseUnit();

            double sumBase = base1 + base2;

            double resultValue = targetUnit.convertFromBaseUnit(sumBase);

            return new Length(resultValue, targetUnit);
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }
}