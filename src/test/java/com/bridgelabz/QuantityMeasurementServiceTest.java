package com.bridgelabz;

import com.bridgelabz.controller.QuantityMeasurementController;
import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.repository.QuantityMeasurementCacheRepository;
import com.bridgelabz.service.QuantityMeasurementServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementServiceTest {

    private QuantityMeasurementController getController() {
        QuantityMeasurementCacheRepository repo =
                QuantityMeasurementCacheRepository.getInstance();
        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repo);
        return new QuantityMeasurementController(service);
    }

    // 🔹 Compare Tests
    @Test
    public void givenSameLength_ShouldReturnTrue() {
        QuantityMeasurementController controller = getController();

        QuantityDTO q1 = new QuantityDTO(12, "INCHES", "Length");
        QuantityDTO q2 = new QuantityDTO(1, "FEET", "Length");

        assertTrue(controller.performCompare(q1, q2));
    }

    @Test
    public void givenDifferentLength_ShouldReturnFalse() {
        QuantityMeasurementController controller = getController();

        QuantityDTO q1 = new QuantityDTO(10, "FEET", "Length");
        QuantityDTO q2 = new QuantityDTO(5, "FEET", "Length");

        assertFalse(controller.performCompare(q1, q2));
    }

    // 🔹 Add Tests
    @Test
    public void givenLength_ShouldAddCorrectly() {
        QuantityMeasurementController controller = getController();

        QuantityDTO q1 = new QuantityDTO(1, "FEET", "Length");
        QuantityDTO q2 = new QuantityDTO(12, "INCHES", "Length");

        QuantityDTO result = controller.performAdd(q1, q2);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    // 🔹 Subtract Tests
    @Test
    public void givenLength_ShouldSubtractCorrectly() {
        QuantityMeasurementController controller = getController();

        QuantityDTO q1 = new QuantityDTO(2, "FEET", "Length");
        QuantityDTO q2 = new QuantityDTO(12, "INCHES", "Length");

        QuantityDTO result = controller.performSubtract(q1, q2);

        assertEquals(1.0, result.getValue(), 0.01);
    }

    // 🔹 Convert Tests
    @Test
    public void givenLength_ShouldConvertCorrectly() {
        QuantityMeasurementController controller = getController();

        QuantityDTO q = new QuantityDTO(1, "FEET", "Length");

        QuantityDTO result = controller.performConvert(q, "INCHES");

        assertEquals(12.0, result.getValue(), 0.01);
    }

    // 🔹 Exception Tests
    @Test
    public void givenDifferentTypes_ShouldThrowException() {
        QuantityMeasurementController controller = getController();

        QuantityDTO q1 = new QuantityDTO(10, "FEET", "Length");
        QuantityDTO q2 = new QuantityDTO(5, "LITER", "Volume");

        assertThrows(RuntimeException.class, () -> {
            controller.performAdd(q1, q2);
        });
    }

    @Test
    public void givenTemperatureAddition_ShouldThrowException() {
        QuantityMeasurementController controller = getController();

        QuantityDTO q1 = new QuantityDTO(10, "CELSIUS", "Temperature");
        QuantityDTO q2 = new QuantityDTO(20, "CELSIUS", "Temperature");

        assertThrows(RuntimeException.class, () -> {
            controller.performAdd(q1, q2);
        });
    }
}