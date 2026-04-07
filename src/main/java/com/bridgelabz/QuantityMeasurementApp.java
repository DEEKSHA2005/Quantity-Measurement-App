package com.bridgelabz;

import com.bridgelabz.controller.QuantityMeasurementController;
import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.repository.QuantityMeasurementCacheRepository;
import com.bridgelabz.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // 1. Create Repository (Singleton)
        QuantityMeasurementCacheRepository repository =
                QuantityMeasurementCacheRepository.getInstance();

        // 2. Inject Repository into Service
        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repository);

        // 3. Inject Service into Controller
        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        // 4. Create Input DTOs
        QuantityDTO q1 = new QuantityDTO(10, "FEET", "Length");
        QuantityDTO q2 = new QuantityDTO(12, "INCH", "Length");

        // 5. Perform Operations

        // ADD
        QuantityDTO addResult = controller.performAdd(q1, q2);
        System.out.println("Add Result: " + addResult.getValue() + " " + addResult.getUnit());

        // SUBTRACT
        QuantityDTO subResult = controller.performSubtract(q1, q2);
        System.out.println("Subtract Result: " + subResult.getValue() + " " + subResult.getUnit());

        // CONVERT
        QuantityDTO convertResult = controller.performConvert(q1, "INCH");
        System.out.println("Convert Result: " + convertResult.getValue() + " " + convertResult.getUnit());

        // COMPARE
        boolean isEqual = controller.performCompare(q1, q2);
        System.out.println("Compare Result: " + isEqual);
    }
}