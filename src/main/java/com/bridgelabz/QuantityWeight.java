package com.bridgelabz;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public double getValue() {
        return value;
    }

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (Kilogram)
    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    // Equality check
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    // Convert weight to another unit
    public QuantityWeight convertTo(WeightUnit target) {

        if (target == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);

        double convertedValue = target.convertFromBaseUnit(baseValue);

        return new QuantityWeight(convertedValue, target);
    }

    // Addition (result in first operand unit)
    public QuantityWeight add(QuantityWeight other) {

        if (other == null)
            throw new IllegalArgumentException("Weight cannot be null");

        double base1 = this.toBaseUnit();

        double base2 = other.toBaseUnit();

        double sumBase = base1 + base2;

        double resultValue = unit.convertFromBaseUnit(sumBase);

        return new QuantityWeight(resultValue, unit);
    }

    // Addition with explicit target unit
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Weight cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base1 = this.toBaseUnit();

        double base2 = other.toBaseUnit();

        double sumBase = base1 + base2;

        double resultValue = targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityWeight(resultValue, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}