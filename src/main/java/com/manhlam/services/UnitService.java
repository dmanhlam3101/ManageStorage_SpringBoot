package com.manhlam.services;

import com.manhlam.dtos.ProductDTO;
import com.manhlam.dtos.UnitDTO;
import com.manhlam.mappers.ProductMapper;
import com.manhlam.mappers.UnitMapper;
import com.manhlam.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    public UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }
    public List<UnitDTO> getAllUnit(){
        return UnitMapper.toDtoList(this.unitRepository.findAll());
    }
}
