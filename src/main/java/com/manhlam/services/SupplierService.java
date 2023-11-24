package com.manhlam.services;

import com.manhlam.dtos.SupplierDTO;
import com.manhlam.mappers.SupplierMapper;
import com.manhlam.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    public SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDTO> getAllSupplier(){
        return (SupplierMapper.toDtoList(this.supplierRepository.findAll()));
    }
}
