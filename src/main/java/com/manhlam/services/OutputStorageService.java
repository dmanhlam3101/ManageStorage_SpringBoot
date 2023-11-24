package com.manhlam.services;


import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.OutputStorageDTO;
import com.manhlam.dtos.OutputStorageResponseDTO;
import com.manhlam.exceptions.NotFoundExeption;
import com.manhlam.mappers.InputStorageMapper;
import com.manhlam.mappers.OutputStorageMapper;
import com.manhlam.models.Customer;
import com.manhlam.models.OutputStorage;
import com.manhlam.models.Product;
import com.manhlam.repositories.CustomerRepository;
import com.manhlam.repositories.OutputStorageRepository;
import com.manhlam.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OutputStorageService {

    @Autowired
    private OutputStorageRepository outputStorageRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public OutputStorageService(OutputStorageRepository outputStorageRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.outputStorageRepository = outputStorageRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public List<OutputStorageDTO> getAllOutputStorageByProductId(Integer productId){
        return OutputStorageMapper.toDtoList(this.outputStorageRepository.findAllByProductId(productId));
    }

    public  List<OutputStorageResponseDTO> getAllOutputStorage(){
        return  OutputStorageMapper.toResponseDtoList(this.outputStorageRepository.getAll());
    }

    public  OutputStorageDTO createOutputStorage( OutputStorageDTO outputStorageDTO){
        return OutputStorageMapper.toDto(this.outputStorageRepository.save(OutputStorageMapper.toEntity(outputStorageDTO)));
    }
    public OutputStorageDTO editOutputStorage(int outputStorageId,OutputStorageDTO outputStorageDTO){
        OutputStorage outputStorage  = outputStorageRepository.findByOutputId(outputStorageId)
                .orElseThrow(() -> new NotFoundExeption("OutputStorage with id"+outputStorageId+"not found"));
        List<Product> products = productRepository.findByProductIdIn(outputStorageDTO.getProductId());
        List<Customer> customers = customerRepository.findByCustomerIdIn(outputStorageDTO.getCustomerId());
        // Convert the list  to a set
        Set<Product> productSet = new HashSet<>(products);
        Set<Customer> customerSet = new HashSet<>(customers);
        outputStorage.setProducts(productSet);
        outputStorage.setCustomers(customerSet);
        outputStorage.setQuantity(outputStorageDTO.getQuantity());
        outputStorage.setDateOutput(outputStorageDTO.getDateOutput());
        outputStorage.setStatus(outputStorageDTO.getStatus());

        return  OutputStorageMapper.toDto(this.outputStorageRepository.save(outputStorage));

    }
}
