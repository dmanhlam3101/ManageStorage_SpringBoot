package com.manhlam.services;

import com.manhlam.dtos.*;
import com.manhlam.mappers.InputStorageMapper;
import com.manhlam.mappers.OutputStorageMapper;
import com.manhlam.mappers.ProductMapper;
import com.manhlam.repositories.InputStorageRepository;
import com.manhlam.repositories.OutputStorageRepository;
import com.manhlam.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InputStorageRepository inputStorageRepository;
    @Autowired
    private OutputStorageRepository  outputStorageRepository;

    public StorageService(ProductRepository productRepository, InputStorageRepository inputStorageRepository, OutputStorageRepository outputStorageRepository) {
        this.productRepository = productRepository;
        this.inputStorageRepository = inputStorageRepository;
        this.outputStorageRepository = outputStorageRepository;
    }



    public List<StorageDTO> getAll(){
        List<ProductDTO> products = ProductMapper.toDtoList(this.productRepository.findAll());
        List<StorageDTO> storageDTOS = new ArrayList<>();

        for(ProductDTO product : products){
            List<InputStorageDTO> inputStorageDTOS = InputStorageMapper.toDtoList(this.inputStorageRepository.findAllByProductId(product.getProductId()));
            List<OutputStorageDTO> outputStorageDTOS = OutputStorageMapper.toDtoList(this.outputStorageRepository.findAllByProductId(product.getProductId()));
            // quantity of product in storage equal total quantity of this product in inputStorage - total quantity of this product in outputStorage hii^^!
            int sumInput = 0;
            int sumOutput = 0;
            if(inputStorageDTOS != null){
                sumInput += inputStorageDTOS.stream().mapToInt(i -> i.getQuantity()).sum();
            }
            if(outputStorageDTOS != null){
                sumOutput += outputStorageDTOS.stream().mapToInt( o  -> o.getQuantity()).sum();
            }
            StorageDTO newStorageDTO = new StorageDTO();
            newStorageDTO.setProductId(product.getProductId());
            newStorageDTO.setProductName(product.getProductName());
            newStorageDTO.setQuantity(sumInput - sumOutput);
            newStorageDTO.setUnitName(product.getUnit().getUnitName());

            if(product.getSupplier() != null){
                newStorageDTO.setSupplierDTO( product.getSupplier());
            }
            storageDTOS.add(newStorageDTO);
        }
        return storageDTOS;
    }
}
