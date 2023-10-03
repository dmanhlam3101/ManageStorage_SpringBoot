package com.manhlam.controllers;


import com.manhlam.dtos.OutputStorageDTO;
import com.manhlam.services.OutputStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/output_storages")
public class OutputStorageController {

    private OutputStorageService outputStorageService;

    public OutputStorageController(OutputStorageService outputStorageService) {
        this.outputStorageService = outputStorageService;
    }

    @GetMapping("{productId}")
    public ResponseEntity<List<OutputStorageDTO>> getAllOutputStorageByProductId(@PathVariable Integer productId) {
        return new ResponseEntity<>(outputStorageService.getAllOutputStorageByProductId(productId), HttpStatus.OK);
    }
}
