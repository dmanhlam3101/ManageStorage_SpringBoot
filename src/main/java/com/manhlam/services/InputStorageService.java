package com.manhlam.services;


import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.ProductDTO;
import com.manhlam.mappers.InputStorageMapper;
import com.manhlam.mappers.ProductMapper;
import com.manhlam.repositories.InputStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputStorageService {

    @Autowired
    private InputStorageRepository inputStorageRepository;

    public InputStorageService(InputStorageRepository inputStorageRepository) {
        this.inputStorageRepository = inputStorageRepository;
    }

    public List<InputStorageDTO> getAllInputStorageByProductId(Integer productId){
        return InputStorageMapper.toDtoList(this.inputStorageRepository.findAllByProductId(productId));
    }
    public List<InputStorageDTO> getAllInputStorage(){
        return InputStorageMapper.toDtoList(this.inputStorageRepository.findAll());
    }
}
