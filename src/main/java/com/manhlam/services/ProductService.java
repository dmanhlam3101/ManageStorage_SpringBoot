package com.manhlam.services;

import com.manhlam.dtos.ProductDTO;
import com.manhlam.mappers.ProductMapper;
import com.manhlam.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll(){
        return ProductMapper.toDtoList(this.productRepository.findAll());
    }
}
