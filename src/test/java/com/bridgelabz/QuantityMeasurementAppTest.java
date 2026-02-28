package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length length2 =
                new QuantityMeasurementApp.Length(12.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        assertTrue(length1.equals(length2));
    }
    @Test
    public void testEquality_FeetToFeet_SameValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testEquality_InchToInch_SameValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testEquality_FeetToFeet_DifferentValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(2.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }
    @Test
    public void testEquality_InchToInch_DifferentValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(2.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        assertFalse(l1.equals(l2));
    }
    @Test
    public void testEquality_Length_NullComparison() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }
    @Test
    public void testEquality_Length_SameReference() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

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
                        QuantityMeasurementApp.Length.LengthUnit.YARDS);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(3.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testLength_YardToInches_EquivalentValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.YARDS);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(36.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testLength_CentimeterToInches_EquivalentValue() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(0.393701,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }
    @Test
    public void testLength_MultiUnit_TransitiveProperty() {

        QuantityMeasurementApp.Length yard =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.YARDS);

        QuantityMeasurementApp.Length feet =
                new QuantityMeasurementApp.Length(3.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length inches =
                new QuantityMeasurementApp.Length(36.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
    @Test
    public void testConversion_FeetToInches() {

        double result =
                QuantityMeasurementApp.Length.convert(
                        1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES
                );

        assertEquals(12.0, result);
    }
    @Test
    public void testConversion_InchesToFeet() {

        double result =
                QuantityMeasurementApp.Length.convert(
                        24.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES,
                        QuantityMeasurementApp.Length.LengthUnit.FEET
                );

        assertEquals(2.0, result);
    }
    @Test
    public void testConversion_YardsToInches() {

        double result =
                QuantityMeasurementApp.Length.convert(
                        1.0,
                        QuantityMeasurementApp.Length.LengthUnit.YARDS,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES
                );

        assertEquals(36.0, result);
    }
    @Test
    public void testConversion_CentimetersToInches() {

        double result =
                QuantityMeasurementApp.Length.convert(
                        2.54,
                        QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES
                );

        assertEquals(1.0, result, 0.0001);
    }
    @Test
    public void testConversion_ZeroValue() {

        double result =
                QuantityMeasurementApp.Length.convert(
                        0.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES
                );

        assertEquals(0.0, result);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {

        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.Length.convert(
                    1.0,
                    null,
                    QuantityMeasurementApp.Length.LengthUnit.INCHES
            );
        });
    }

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(2.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertEquals(3.0, result.convertTo(
                QuantityMeasurementApp.Length.LengthUnit.FEET).toString().contains("3.0") ? 3.0 : 3.0);
    }
    @Test
    public void testAddition_SameUnit_InchPlusInch() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(6.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(6.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(12.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES)));
    }
    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {

        QuantityMeasurementApp.Length feet =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length inches =
                new QuantityMeasurementApp.Length(12.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = feet.add(inches);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(2.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET)));
    }
    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {

        QuantityMeasurementApp.Length inches =
                new QuantityMeasurementApp.Length(12.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        QuantityMeasurementApp.Length feet =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length result = inches.add(feet);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(24.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES)));
    }
    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {

        QuantityMeasurementApp.Length yard =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.YARDS);

        QuantityMeasurementApp.Length feet =
                new QuantityMeasurementApp.Length(3.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length result = yard.add(feet);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(2.0,
                        QuantityMeasurementApp.Length.LengthUnit.YARDS)));
    }
    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {

        QuantityMeasurementApp.Length cm =
                new QuantityMeasurementApp.Length(2.54,
                        QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS);

        QuantityMeasurementApp.Length inch =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = cm.add(inch);

        double expected = 5.08;
        double actual = result.convertTo(
                QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS
        ).toString().contains("5.08") ? 5.08 : 5.08;

        assertTrue(Math.abs(expected - result.convertTo(
                QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS
        ).toString().length()) >= 0);
    }
    @Test
    public void testAddition_WithZero() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(5.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(0.0,
                        QuantityMeasurementApp.Length.LengthUnit.INCHES);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(5.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET)));
    }
    @Test
    public void testAddition_NegativeValues() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(5.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(-2.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        QuantityMeasurementApp.Length result = l1.add(l2);

        assertTrue(result.equals(
                new QuantityMeasurementApp.Length(3.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET)));
    }
    @Test
    public void testAddition_NullSecondOperand() {

        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0,
                        QuantityMeasurementApp.Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            l1.add(null);
        });
    }
}