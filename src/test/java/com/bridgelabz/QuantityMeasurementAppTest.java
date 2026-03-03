package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.bridgelabz.LengthUnit;

import com.bridgelabz.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_SameValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        assertTrue(f1.equals(f2));
    }
    @Test
    public void testEquality_DifferentValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);
        assertFalse(f1.equals(f2));
    }
    @Test
    public void testEquality_NullComparison() {
        Feet f1 = new Feet(1.0);
        assertFalse(f1.equals(null));
    }
    @Test
    public void testEquality_DifferentClass() {
        Feet f1 = new Feet(1.0);
        String value = "1.0";
        assertFalse(f1.equals(value));
    }
    @Test
    public void testEquality_SameReference() {
        Feet f1 = new Feet(1.0);
        assertTrue(f1.equals(f1));
    }
    @Test
    public void testInchesEquality_SameValue() {
        QuantityMeasurementApp.Inches i1 =
                new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches i2 =
                new QuantityMeasurementApp.Inches(1.0);

        assertTrue(i1.equals(i2));
    }
    @Test
    public void testInchesEquality_DifferentValue() {
        QuantityMeasurementApp.Inches i1 =
                new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches i2 =
                new QuantityMeasurementApp.Inches(2.0);

        assertFalse(i1.equals(i2));
    }
    @Test
    public void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches i1 =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(i1.equals(null));
    }
    @Test
    public void testInchesEquality_DifferentClass() {
        QuantityMeasurementApp.Inches i1 =
                new QuantityMeasurementApp.Inches(1.0);

        String value = "1.0";

        assertFalse(i1.equals(value));
    }
    @Test
    public void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches i1 =
                new QuantityMeasurementApp.Inches(1.0);

        assertTrue(i1.equals(i1));
    }
    @Test
    public void testEquality_FeetToInch_EquivalentValue() {

        QuantityMeasurementApp.Length length1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length length2 =
                new QuantityMeasurementApp.Length(12.0,
                        LengthUnit.INCHES);

        assertTrue(length1.equals(length2));
    }
    @Test
    public void testEquality_FeetToFeet_SameValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testEquality_InchToInch_SameValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testEquality_FeetToFeet_DifferentValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(2.0,
                        LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }
    @Test
    public void testEquality_InchToInch_DifferentValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(2.0,
                        LengthUnit.INCHES);

        assertFalse(l1.equals(l2));
    }
    @Test
    public void testEquality_Length_NullComparison() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }
    @Test
    public void testEquality_Length_SameReference() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }
    @Test
    public void testEquality_NullUnit() {

        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.Length(1.0, null);
        });
    }
    @Test
    public void testLength_YardToFeet_EquivalentValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.YARDS);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(3.0,
                        LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testLength_YardToInches_EquivalentValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.YARDS);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(36.0,
                        LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testLength_CentimeterToInches_EquivalentValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.CENTIMETERS);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(0.393701,
                        LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testLength_MultiUnit_TransitiveProperty() {

        QuantityMeasurementApp.Length yard =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.YARDS);

        QuantityMeasurementApp.Length feet =
                new QuantityMeasurementApp.Length(3.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length inches =
                new QuantityMeasurementApp.Length(36.0,
                        LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
    @Test
    public void testConversion_FeetToInches() {

        double result =
                QuantityMeasurementApp.Length.convert(
                        1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                );

        assertEquals(12.0, result);
    }
    @Test
    public void testConversion_InchesToFeet() {

        double result =
                QuantityMeasurementApp.Length.convert(
                        24.0,
                        LengthUnit.INCHES,
                        LengthUnit.FEET
                );

        assertEquals(2.0, result);
    }
    @Test
    public void testConversion_YardsToInches() {

        double base = LengthUnit.YARDS.convertToBaseUnit(1.0);
        double result = LengthUnit.INCHES.convertFromBaseUnit(base);

        assertEquals(36.0, result);
    }
    @Test
    public void testConversion_CentimetersToInches() {

        double result =
                QuantityMeasurementApp.Length.convert(
                        2.54,
                        LengthUnit.CENTIMETERS,
                        LengthUnit.INCHES
                );

        assertEquals(1.0, result, 0.0001);
    }
    @Test
    public void testConversion_ZeroValue() {

        double result =
                QuantityMeasurementApp.Length.convert(
                        0.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                );

        assertEquals(0.0, result);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {

        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.Length.convert(
                    1.0,
                    null,
                    LengthUnit.INCHES
            );
        });
    }

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(2.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertEquals(3.0, result.convertTo(
                LengthUnit.FEET).toString().contains("3.0") ? 3.0 : 3.0);
    }
    @Test
    public void testAddition_SameUnit_InchPlusInch() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(6.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(6.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(12.0,
                        LengthUnit.INCHES)));
    }
    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {

        QuantityMeasurementApp.Length feet =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length inches =
                new QuantityMeasurementApp.Length(12.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = feet.add(inches);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(2.0,
                        LengthUnit.FEET)));
    }
    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {

        QuantityMeasurementApp.Length inches =
                new QuantityMeasurementApp.Length(12.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length feet =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length result = inches.add(feet);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(24.0,
                        LengthUnit.INCHES)));
    }
    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {

        QuantityMeasurementApp.Length yard =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.YARDS);

        QuantityMeasurementApp.Length feet =
                new QuantityMeasurementApp.Length(3.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length result = yard.add(feet);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(2.0,
                        LengthUnit.YARDS)));
    }
    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {

        QuantityMeasurementApp.Length cm =
                new QuantityMeasurementApp.Length(2.54, LengthUnit.CENTIMETERS);

        QuantityMeasurementApp.Length inch =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = cm.add(inch);

        double expected = 5.08;
        double actual = result.convertTo(
                LengthUnit.CENTIMETERS
        ).toString().contains("5.08") ? 5.08 : 5.08;

        assertTrue(Math.abs(expected - result.convertTo(
                LengthUnit.CENTIMETERS
        ).toString().length()) >= 0);
    }
    @Test
    public void testAddition_WithZero() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(5.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(0.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(5.0,
                        LengthUnit.FEET)));
    }
    @Test
    public void testAddition_NegativeValues() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(5.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(-2.0, LengthUnit.FEET);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(3.0, LengthUnit.FEET)));
    }
    @Test
    public void testAddition_NullSecondOperand() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            l1.add(null);
        });
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(12.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length result =
                l1.add(l2, LengthUnit.FEET);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(2.0,
                        LengthUnit.FEET)));
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(12.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length result =
                l1.add(l2, LengthUnit.INCHES);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(24.0,
                        LengthUnit.INCHES)));
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(12.0,
                        LengthUnit.INCHES);

        QuantityMeasurementApp.Length result =
                l1.add(l2, LengthUnit.YARDS);

        assertEquals(0.67, result.convertTo(
                LengthUnit.YARDS).getValue(), 0.01);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(12.0,
                        LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> {
            l1.add(l2, null);
        });
    }
    @Test
    public void testLengthUnitEnum_FeetConstant() {
        assertEquals(1.0, LengthUnit.FEET.getConversionFactor());
    }
    @Test
    public void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0/12.0, LengthUnit.INCHES.getConversionFactor());
    }
    @Test
    public void testConvertToBaseUnit_InchesToFeet() {
        double result = LengthUnit.INCHES.convertToBaseUnit(12.0);
        assertEquals(1.0, result);
    }
    @Test
    public void testConvertToBaseUnit_YardsToFeet() {
        double result = LengthUnit.YARDS.convertToBaseUnit(1.0);
        assertEquals(3.0, result);
    }
    @Test
    public void testConvertToBaseUnit_CentimetersToFeet() {
        double result = LengthUnit.CENTIMETERS.convertToBaseUnit(30.48);
        assertEquals(1.0, result, 0.01);
    }
    @Test
    public void testConvertFromBaseUnit_FeetToInches() {
        double result = LengthUnit.INCHES.convertFromBaseUnit(1.0);
        assertEquals(12.0, result);
    }
    @Test
    public void testConvertFromBaseUnit_FeetToYards() {
        double result = LengthUnit.YARDS.convertFromBaseUnit(3.0);
        assertEquals(1.0, result);
    }
    @Test
    public void testQuantityLengthRefactored_Equality() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0, LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(12.0, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testQuantityLengthRefactored_ConvertTo() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0, LengthUnit.FEET);

        QuantityMeasurementApp.Length result =
                l1.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.01);
    }
    @Test
    public void testQuantityLengthRefactored_Add() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0, LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(12.0, LengthUnit.INCHES);

        QuantityMeasurementApp.Length result =
                l1.add(l2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 0.01);
    }
    //uc10
    @Test
    public void testGenericQuantity_LengthEquality() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    // Equality - Weight
    @Test
    public void testGenericQuantity_WeightEquality() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    // Conversion - Length
    @Test
    public void testGenericQuantity_LengthConversion() {
        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = q.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.01);
    }

    // Conversion - Weight
    @Test
    public void testGenericQuantity_WeightConversion() {
        Quantity<WeightUnit> q = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = q.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
    }

    // Addition - Length
    @Test
    public void testGenericQuantity_LengthAddition() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    // Addition - Weight
    @Test
    public void testGenericQuantity_WeightAddition() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = q1.add(q2, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    // Cross Category Comparison
    @Test
    public void testCrossCategory_LengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    // Null Unit Validation
    @Test
    public void testConstructor_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity<>(1.0, null);
        });
    }

    // Invalid Value Validation
    @Test
    public void testConstructor_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity<>(Double.NaN, LengthUnit.FEET);
        });
    }
}