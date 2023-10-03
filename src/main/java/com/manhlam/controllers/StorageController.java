package com.manhlam.controllers;


import com.manhlam.dtos.StorageDTO;
import com.manhlam.services.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Storage")
public class StorageController {

    private StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping

    public ResponseEntity<List<StorageDTO>>getAll(){
        return new  ResponseEntity<>(this.storageService.getAll(), HttpStatus.OK);
    }
}
