package com.bridgelabz.repository;

import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuantityMeasurementDatabaseRepository {

    public void save(QuantityDTO dto) {

        String sql = "INSERT INTO measurement (value, unit, type) VALUES (?, ?, ?)";

        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, dto.getValue());
            ps.setString(2, dto.getUnit());
            ps.setString(3, dto.getMeasurementType());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("DB Insert Failed", e);
        }
    }
}