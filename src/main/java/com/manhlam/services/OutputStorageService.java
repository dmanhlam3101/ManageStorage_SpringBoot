package com.manhlam.services;


import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.OutputStorageDTO;
import com.manhlam.mappers.InputStorageMapper;
import com.manhlam.mappers.OutputStorageMapper;
import com.manhlam.repositories.OutputStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutputStorageService {

    @Autowired
    private OutputStorageRepository outputStorageRepository;

    public OutputStorageService(OutputStorageRepository outputStorageRepository) {
        this.outputStorageRepository = outputStorageRepository;
    }

    public List<OutputStorageDTO> getAllOutputStorageByProductId(Integer productId){
        return OutputStorageMapper.toDtoList(this.outputStorageRepository.findAllByProductId(productId));
    }
}
