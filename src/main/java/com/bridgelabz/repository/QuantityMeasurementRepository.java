package com.bridgelabz.repository;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityMeasurementRepository
        extends JpaRepository<QuantityMeasurementEntity, Integer> {
}