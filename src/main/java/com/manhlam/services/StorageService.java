package com.manhlam.services;

import com.manhlam.dtos.StorageDTO;
import com.manhlam.repositories.InputStorageRepository;
import com.manhlam.repositories.OutputStorageRepository;
import com.manhlam.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



//    public List<StorageDTO> getAll(){
//        retu
//    }
}
