package com.bridgelabz.controller;

import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.dto.AddRequestDTO;
import com.bridgelabz.dto.SubtractRequestDTO;
import com.bridgelabz.dto.CompareRequestDTO;
import com.bridgelabz.dto.ConvertRequestDTO;
import com.bridgelabz.service.IQuantityMeasurementService;


import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public QuantityDTO performAdd(QuantityDTO q1, QuantityDTO q2) {
        return service.add(q1, q2);
    }

    public QuantityDTO performSubtract(QuantityDTO q1, QuantityDTO q2) {
        return service.subtract(q1, q2);
    }

    public QuantityDTO performConvert(QuantityDTO q, String targetUnit) {
        return service.convert(q, targetUnit);
    }

    public boolean performCompare(QuantityDTO q1, QuantityDTO q2) {
        return service.compare(q1, q2);
    }

    @PostMapping("/add")
    public QuantityDTO add(@RequestBody AddRequestDTO request) {
        return service.add(request.getQ1(), request.getQ2());
    }

    @PostMapping("/subtract")
    public QuantityDTO subtract(@RequestBody SubtractRequestDTO request) {
        return service.subtract(request.getQ1(), request.getQ2());
    }

    @PostMapping("/compare")
    public boolean compare(@RequestBody CompareRequestDTO request) {
        return service.compare(request.getQ1(), request.getQ2());
    }

    @PostMapping("/convert")
    public QuantityDTO convert(@RequestBody ConvertRequestDTO request) {
        return service.convert(request.getQuantity(), request.getTargetUnit());
    }
}