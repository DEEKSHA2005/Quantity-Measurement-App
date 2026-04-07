package com.bridgelabz.service;

import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.model.QuantityModel;
import com.bridgelabz.IMeasurable;
import com.bridgelabz.LengthUnit;
import com.bridgelabz.WeightUnit;
import com.bridgelabz.VolumeUnit;
import com.bridgelabz.TemperatureUnit;
import com.bridgelabz.repository.IQuantityMeasurementRepository;
import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.exception.QuantityMeasurementException;


public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        // 1. Convert DTO → Model
        QuantityModel<IMeasurable> m1 = toModel(q1);
        QuantityModel<IMeasurable> m2 = toModel(q2);

        // 2. Validate same measurement type
        if (!m1.getUnit().getMeasurementType()
                .equals(m2.getUnit().getMeasurementType())) {
            throw new QuantityMeasurementException("Cannot add different measurement types");
        }

        // 3. Check arithmetic support
        if (!m1.getUnit().supportsArithmetic()) {
            throw new QuantityMeasurementException("Addition not supported for this unit");
        }

        // 4. Convert to base unit
        double base1 = m1.getUnit().convertToBaseUnit(m1.getValue());
        double base2 = m2.getUnit().convertToBaseUnit(m2.getValue());

        // 5. Add
        double resultBase = base1 + base2;

        // 6. Convert back to original unit
        double finalValue = m1.getUnit().convertFromBaseUnit(resultBase);

        repository.save(
                new QuantityMeasurementEntity(
                        "ADD",
                        finalValue + " " + m1.getUnit().getUnitName()
                )
        );

        // 7. Return DTO
        return new QuantityDTO(
                finalValue,
                m1.getUnit().getUnitName(),
                m1.getUnit().getMeasurementType()
        );
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        // 1. Convert DTO → Model
        QuantityModel<IMeasurable> m1 = toModel(q1);
        QuantityModel<IMeasurable> m2 = toModel(q2);

        // 2. Validate same measurement type
        if (!m1.getUnit().getMeasurementType()
                .equals(m2.getUnit().getMeasurementType())) {
            throw new QuantityMeasurementException("Cannot subtract different measurement types");
        }

        // 3. Check arithmetic support
        if (!m1.getUnit().supportsArithmetic()) {
            throw new QuantityMeasurementException("Subtraction not supported for this unit");
        }

        // 4. Convert to base unit
        double base1 = m1.getUnit().convertToBaseUnit(m1.getValue());
        double base2 = m2.getUnit().convertToBaseUnit(m2.getValue());

        // 5. Subtract
        double resultBase = base1 - base2;

        // 6. Convert back to original unit
        double finalValue = m1.getUnit().convertFromBaseUnit(resultBase);

        repository.save(
                new QuantityMeasurementEntity(
                        "SUBTRACT",
                        finalValue + " " + m1.getUnit().getUnitName()
                )
        );

        // 7. Return DTO
        return new QuantityDTO(
                finalValue,
                m1.getUnit().getUnitName(),
                m1.getUnit().getMeasurementType()
        );
    }

    @Override
    public QuantityDTO convert(QuantityDTO q, String targetUnit) {

        // 1. Convert DTO → Model
        QuantityModel<IMeasurable> model = toModel(q);

        // 2. Get target unit
        IMeasurable target = getUnit(targetUnit);

        // 3. Validate same measurement type
        if (!model.getUnit().getMeasurementType()
                .equals(target.getMeasurementType())) {
            throw new QuantityMeasurementException("Invalid conversion between different measurement types");
        }

        // 4. Convert to base unit
        double baseValue = model.getUnit().convertToBaseUnit(model.getValue());

        // 5. Convert base → target unit
        double convertedValue = target.convertFromBaseUnit(baseValue);

        repository.save(
                new QuantityMeasurementEntity(
                        "CONVERT",
                        convertedValue + " " + target.getUnitName()
                )
        );

        // 6. Return DTO
        return new QuantityDTO(
                convertedValue,
                target.getUnitName(),
                target.getMeasurementType()
        );
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {

        // 1. Convert DTO → Model
        QuantityModel<IMeasurable> m1 = toModel(q1);
        QuantityModel<IMeasurable> m2 = toModel(q2);

        // 2. Validate same measurement type
        if (!m1.getUnit().getMeasurementType()
                .equals(m2.getUnit().getMeasurementType())) {
            return false;
        }

        // 3. Convert to base unit
        double base1 = m1.getUnit().convertToBaseUnit(m1.getValue());
        double base2 = m2.getUnit().convertToBaseUnit(m2.getValue());

        repository.save(
                new QuantityMeasurementEntity(
                        "COMPARE",
                        String.valueOf(Math.abs(base1 - base2) < 0.01)
                )
        );

        // 4. Compare with tolerance (important for double)
        return Math.abs(base1 - base2) < 0.01;
    }

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
}