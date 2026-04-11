package com.bridgelabz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "measurement")
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double value;
    private String unit;
    private String type;

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}