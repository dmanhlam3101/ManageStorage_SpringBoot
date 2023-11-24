package com.manhlam.controllers;

import com.manhlam.dtos.ProductDTO;
import com.manhlam.dtos.ProductRequestDTO;
import com.manhlam.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int productId) {

        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }
    @PutMapping("delete/{productId}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable int productId) {

        return new ResponseEntity<>(productService.deleteProduct(productId), HttpStatus.OK);
    }
    @PutMapping("edit/{productId}")
    public ResponseEntity<ProductDTO> editProduct(@PathVariable int productId,
                                                  @RequestBody @Valid ProductRequestDTO productRequestDto) {

        return new ResponseEntity<>(productService.eidtProduct(productId,productRequestDto), HttpStatus.OK);
    }
    @PostMapping("add")
    public ResponseEntity<ProductDTO> addProduct( @RequestBody @Valid ProductRequestDTO productRequestDto) {
//        int unitId = principal.getUnitId();
//        assignmentRequestDto.setAssigner(username);
        return new ResponseEntity<>(productService.addProduct(productRequestDto), HttpStatus.CREATED);
    }

}
