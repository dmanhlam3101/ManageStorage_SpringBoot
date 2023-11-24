package com.manhlam.services;


import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.InputStorageResponseDTO;
import com.manhlam.exceptions.NotFoundExeption;
import com.manhlam.mappers.InputStorageMapper;
import com.manhlam.models.InputStorage;
import com.manhlam.models.Product;
import com.manhlam.repositories.InputStorageRepository;
import com.manhlam.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InputStorageService {

    @Autowired
    private InputStorageRepository inputStorageRepository;
    @Autowired
    private ProductRepository productRepository;


    public InputStorageService(InputStorageRepository inputStorageRepository, ProductRepository productRepository) {
        this.inputStorageRepository = inputStorageRepository;
        this.productRepository = productRepository;
    }

    public List<InputStorageDTO> getAllInputStorageByProductId(Integer productId){
        return InputStorageMapper.toDtoList(this.inputStorageRepository.findAllByProductId(productId));
    }
    public List<InputStorageDTO> getAllInputStorage(){
        return InputStorageMapper.toDtoList(this.inputStorageRepository.findAll());
    }
    public InputStorageDTO createInputStorage(InputStorageDTO inputStorageDTO){
        return  InputStorageMapper.toDto(this.inputStorageRepository.save(InputStorageMapper.toEntity(inputStorageDTO)));
    }

    public InputStorageDTO editInputStorage(int inputStorageId,InputStorageDTO inputStorageDTO){
        InputStorage inputStorage = inputStorageRepository.findByInputId(inputStorageId)
                .orElseThrow(() ->  new NotFoundExeption("Input storage with Id"+inputStorageId+"not found"));
        // Retrieve products using the product IDs
        List<Product> products = productRepository.findByProductIdIn(inputStorageDTO.getProductId());

        // Convert the list of products to a set
        Set<Product> productSet = new HashSet<>(products);

        inputStorage.setProducts(productSet);
        inputStorage.setDateInput(inputStorageDTO.getDateInput());
        inputStorage.setInputPrice(inputStorageDTO.getInputPrice());
        inputStorage.setQuantity(inputStorageDTO.getQuantity());
        inputStorage.setOutputPrice(inputStorageDTO.getOutputPrice());
        inputStorage.setStatus(inputStorageDTO.getStatus());
        return  InputStorageMapper.toDto(this.inputStorageRepository.save(inputStorage));
    }
    public InputStorageDTO deleteInputStorage (int inputStorageId){
        InputStorage inputStorage = inputStorageRepository.findByInputId(inputStorageId)
                .orElseThrow(() ->  new NotFoundExeption("Input storage with Id"+inputStorageId+"not found"));
        inputStorage.setStatus(false);
        return  InputStorageMapper.toDto(this.inputStorageRepository.save(inputStorage));
    }
    public List<InputStorageResponseDTO> getAll(){
        return InputStorageMapper.toDtoResponseList(this.inputStorageRepository.getAll());
    }
    public InputStorageResponseDTO getInputStorageById(int inputStorageId){
        InputStorageResponseDTO inputStorageDTO = InputStorageMapper.toDtoResponse(this.inputStorageRepository.findByInputId(inputStorageId)
                .orElseThrow(() ->  new NotFoundExeption("Input storage with Id"+inputStorageId+"not found")));
        return inputStorageDTO;
    }
}
