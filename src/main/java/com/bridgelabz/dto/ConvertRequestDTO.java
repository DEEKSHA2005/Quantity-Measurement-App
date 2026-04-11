package com.bridgelabz.dto;

public class ConvertRequestDTO {
    private QuantityDTO quantity;
    private String targetUnit;

    public QuantityDTO getQuantity() { return quantity; }
    public void setQuantity(QuantityDTO quantity) { this.quantity = quantity; }

    public String getTargetUnit() { return targetUnit; }
    public void setTargetUnit(String targetUnit) { this.targetUnit = targetUnit; }
}