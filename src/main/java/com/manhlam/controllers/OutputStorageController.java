package com.manhlam.controllers;


import com.manhlam.dtos.OutputStorageDTO;
import com.manhlam.dtos.OutputStorageResponseDTO;
import com.manhlam.services.OutputStorageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/output_storages")
public class OutputStorageController {

    private OutputStorageService outputStorageService;

    public OutputStorageController(OutputStorageService outputStorageService) {
        this.outputStorageService = outputStorageService;
    }

    @GetMapping("{productId}")
    public ResponseEntity<List<OutputStorageDTO>> getAllOutputStorageByProductId(@PathVariable Integer productId) {
        return new ResponseEntity<>(outputStorageService.getAllOutputStorageByProductId(productId), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<OutputStorageResponseDTO>> getAllOutputStorage() {
        return new ResponseEntity<>(outputStorageService.getAllOutputStorage(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<OutputStorageDTO> createOutputStorage(@RequestBody @Valid OutputStorageDTO outputStorageDTO) {
        return new ResponseEntity<>(outputStorageService.createOutputStorage(outputStorageDTO), HttpStatus.CREATED);
    }
}
