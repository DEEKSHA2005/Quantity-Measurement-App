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
}