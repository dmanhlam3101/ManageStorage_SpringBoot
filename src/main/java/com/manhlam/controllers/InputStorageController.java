package com.manhlam.controllers;


import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.InputStorageResponseDTO;
import com.manhlam.services.InputStorageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/input_storages")
public class InputStorageController {

    private InputStorageService inputStorageService;

    public InputStorageController(InputStorageService inputStorageService) {
        this.inputStorageService = inputStorageService;
    }
    @GetMapping
    public ResponseEntity<List<InputStorageResponseDTO>> getAllProducts() {

        return new ResponseEntity<>(inputStorageService.getAll(), HttpStatus.OK);
    }
    @GetMapping("{productId}")
    public ResponseEntity<List<InputStorageDTO>> getAllProductsByProductId(@PathVariable Integer productId) {

        return new ResponseEntity<>(inputStorageService.getAllInputStorageByProductId(productId), HttpStatus.OK);
    }
    @GetMapping("GetInputStorage/{inputStorageId}")
    public ResponseEntity<InputStorageResponseDTO> getInputStorageById(@PathVariable Integer inputStorageId) {

        return new ResponseEntity<>(inputStorageService.getInputStorageById(inputStorageId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InputStorageDTO> createInputStorage(@RequestBody @Valid InputStorageDTO inputStorageDTO) {

        return new ResponseEntity<>(inputStorageService.createInputStorage(inputStorageDTO), HttpStatus.CREATED);
    }
    @PutMapping("{inputStorageId}")
    public ResponseEntity<InputStorageDTO> editInputStorage( @PathVariable Integer inputStorageId,
            @RequestBody @Valid InputStorageDTO inputStorageDTO) {

        return new ResponseEntity<>(inputStorageService.editInputStorage(inputStorageId,inputStorageDTO), HttpStatus.OK);
    }
    @PutMapping("delete/{inputStorageId}")
    public ResponseEntity<InputStorageDTO> deleteInputStorage( @PathVariable Integer inputStorageId) {

        return new ResponseEntity<>(inputStorageService.deleteInputStorage(inputStorageId), HttpStatus.OK);
    }
}
