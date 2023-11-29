package com.manhlam.controllers;


import com.manhlam.dtos.ProductDTO;
import com.manhlam.dtos.UnitDTO;
import com.manhlam.services.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/unit")
public class UnitController {
    private UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }
    @GetMapping
    public ResponseEntity<List<UnitDTO>> getAllUnits() {

        return new ResponseEntity<>(unitService.getAllUnit(), HttpStatus.OK);
    }
}
