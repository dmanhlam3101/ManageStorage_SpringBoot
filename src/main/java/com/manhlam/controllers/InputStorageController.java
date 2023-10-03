package com.manhlam.controllers;


import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.ProductDTO;
import com.manhlam.services.InputStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/input_storages")
public class InputStorageController {

    private InputStorageService inputStorageService;

    public InputStorageController(InputStorageService inputStorageService) {
        this.inputStorageService = inputStorageService;
    }
    @GetMapping
    public ResponseEntity<List<InputStorageDTO>> getAllProducts() {

        return new ResponseEntity<>(inputStorageService.getAllInputStorage(), HttpStatus.OK);
    }
    @GetMapping("{productId}")
    public ResponseEntity<List<InputStorageDTO>> getAllProductsByProductId(@PathVariable Integer productId) {

        return new ResponseEntity<>(inputStorageService.getAllInputStorageByProductId(productId), HttpStatus.OK);
    }
}
