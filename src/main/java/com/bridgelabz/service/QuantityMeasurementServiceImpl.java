package com.bridgelabz.service;

import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.model.QuantityModel;
import com.bridgelabz.IMeasurable;
import com.bridgelabz.LengthUnit;
import com.bridgelabz.WeightUnit;
import com.bridgelabz.VolumeUnit;
import com.bridgelabz.TemperatureUnit;
import com.bridgelabz.exception.QuantityMeasurementException;
import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.QuantityMeasurementRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    private QuantityModel<IMeasurable> toModel(QuantityDTO dto) {

        IMeasurable unit = getUnit(dto.getUnit());

        return new QuantityModel<>(dto.getValue(), unit);
    }

    private IMeasurable getUnit(String unitName) {

        // Length
        for (LengthUnit unit : LengthUnit.values()) {
            if (unit.name().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }

        // Weight
        for (WeightUnit unit : WeightUnit.values()) {
            if (unit.name().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }

        // Volume
        for (VolumeUnit unit : VolumeUnit.values()) {
            if (unit.name().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }

        // Temperature
        for (TemperatureUnit unit : TemperatureUnit.values()) {
            if (unit.name().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }

        throw new QuantityMeasurementException("Invalid unit: " + unitName);
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        QuantityModel<IMeasurable> m1 = toModel(q1);
        QuantityModel<IMeasurable> m2 = toModel(q2);

        // Validate same type
        if (!m1.getUnit().getMeasurementType()
                .equals(m2.getUnit().getMeasurementType())) {
            throw new QuantityMeasurementException("Cannot add different measurement types");
        }

        // Check arithmetic support
        if (!m1.getUnit().supportsArithmetic()) {
            throw new QuantityMeasurementException("Addition not supported");
        }

        // Convert to base
        double base1 = m1.getUnit().convertToBaseUnit(m1.getValue());
        double base2 = m2.getUnit().convertToBaseUnit(m2.getValue());

        // Add
        double resultBase = base1 + base2;

        // Convert back
        double finalValue = m1.getUnit().convertFromBaseUnit(resultBase);

        QuantityDTO result = new QuantityDTO(
                finalValue,
                m1.getUnit().getUnitName(),
                m1.getUnit().getMeasurementType()
        );

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
        entity.setValue(result.getValue());
        entity.setUnit(result.getUnit());
        entity.setType(result.getMeasurementType());

        repository.save(entity);

        return result;
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        QuantityModel<IMeasurable> m1 = toModel(q1);
        QuantityModel<IMeasurable> m2 = toModel(q2);

        if (!m1.getUnit().getMeasurementType()
                .equals(m2.getUnit().getMeasurementType())) {
            throw new QuantityMeasurementException("Cannot subtract different types");
        }

        if (!m1.getUnit().supportsArithmetic()) {
            throw new QuantityMeasurementException("Subtraction not supported");
        }

        double base1 = m1.getUnit().convertToBaseUnit(m1.getValue());
        double base2 = m2.getUnit().convertToBaseUnit(m2.getValue());

        double resultBase = base1 - base2;

        double finalValue = m1.getUnit().convertFromBaseUnit(resultBase);

        QuantityDTO result = new QuantityDTO(
                finalValue,
                m1.getUnit().getUnitName(),
                m1.getUnit().getMeasurementType()
        );
        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
        entity.setValue(result.getValue());
        entity.setUnit(result.getUnit());
        entity.setType(result.getMeasurementType());

        repository.save(entity);

        return result;
    }

    @Override
    public QuantityDTO convert(QuantityDTO q, String targetUnit) {

        QuantityModel<IMeasurable> model = toModel(q);
        IMeasurable target = getUnit(targetUnit);

        if (!model.getUnit().getMeasurementType()
                .equals(target.getMeasurementType())) {
            throw new QuantityMeasurementException("Invalid conversion");
        }

        double baseValue = model.getUnit().convertToBaseUnit(model.getValue());
        double convertedValue = target.convertFromBaseUnit(baseValue);

        QuantityDTO result = new QuantityDTO(
                convertedValue,
                target.getUnitName(),
                target.getMeasurementType()
        );
        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
        entity.setValue(result.getValue());
        entity.setUnit(result.getUnit());
        entity.setType(result.getMeasurementType());

        repository.save(entity);

        return result;
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {

        QuantityModel<IMeasurable> m1 = toModel(q1);
        QuantityModel<IMeasurable> m2 = toModel(q2);

        if (!m1.getUnit().getMeasurementType()
                .equals(m2.getUnit().getMeasurementType())) {
            return false;
        }

        double base1 = m1.getUnit().convertToBaseUnit(m1.getValue());
        double base2 = m2.getUnit().convertToBaseUnit(m2.getValue());

        boolean result = Math.abs(base1 - base2) < 0.01;

        return result;
    }
}