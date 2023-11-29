package com.manhlam.mappers;

import com.manhlam.dtos.*;
import com.manhlam.models.Customer;
import com.manhlam.models.InputStorage;
import com.manhlam.models.OutputStorage;
import com.manhlam.models.Product;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputStorageMapper {
    public static OutputStorageDTO toDto(OutputStorage outputStorage) {
        OutputStorageDTO  storageDTO = new OutputStorageDTO();
        storageDTO.setOutputId(outputStorage.getOutputId());
        storageDTO.setQuantity(outputStorage.getQuantity());
        storageDTO.setDateOutput(outputStorage.getDateOutput());
        storageDTO.setStatus(outputStorage.getStatus());

        return storageDTO;
    }
    public static OutputStorageResponseDTO toResponseDto(OutputStorage outputStorage) {
        OutputStorageResponseDTO  outputStorageResponseDTO = new OutputStorageResponseDTO();
        Set<ProductDTO> products = outputStorage.getProducts().stream()
                .map(product -> new ProductDTO(
                        product.getProductId(),
                        product.getProductName(),
                        product.isStatus(),
                        product.getUnit(),
                        product.getSupplier()

                ))
                .collect(Collectors.toSet());
        outputStorageResponseDTO.setProduct(products);
        Set<CustomerDAO> customerDAOS = outputStorage.getCustomers().stream()
                .map(customer -> new CustomerDAO(
                        customer.getCustomerId(),
                        customer.getDisplayName(),
                        customer.getAddress(),
                        customer.getPhone(),
                        customer.getEmail(),
                        customer.getMoreInfo(),
                        customer.getContractDate(),
                        customer.getStatus(),
                        customer.getOutputStorages()

                ))
                .collect(Collectors.toSet());
        outputStorageResponseDTO.setCustomer(customerDAOS);
        outputStorageResponseDTO.setOutputId(outputStorage.getOutputId());
        outputStorageResponseDTO.setQuantity(outputStorage.getQuantity());
        outputStorageResponseDTO.setDateOutput(outputStorage.getDateOutput());
        outputStorageResponseDTO.setStatus(outputStorage.getStatus());

        return outputStorageResponseDTO;
    }

    public static List<OutputStorageDTO> toDtoList(List<OutputStorage> outputStorage) {
        return  outputStorage.stream().map(OutputStorageMapper::toDto).collect(Collectors.toList());
    }
    public static List<OutputStorageResponseDTO> toResponseDtoList(List<OutputStorage> outputStorage) {
        return  outputStorage.stream().map(OutputStorageMapper::toResponseDto).collect(Collectors.toList());
    }

    public static OutputStorage toEntity(OutputStorageDTO outputStorageDTO) {
        OutputStorage outputStorage = new OutputStorage();
        outputStorage.setOutputId(outputStorageDTO.getOutputId());
        outputStorage.setQuantity(outputStorageDTO.getQuantity());
        outputStorage.setDateOutput(outputStorageDTO.getDateOutput());
        outputStorage.setStatus(outputStorageDTO.getStatus());
        // Assuming there's a method to fetch products by productIds
        Set<Product> products = outputStorageDTO.getProductId().stream()
                .map(productId -> {
                    Product product = new Product();
                    product.setProductId(productId);
                    return product;
                })
                .collect(Collectors.toSet());
        outputStorage.setProducts(products);

        Set<Customer> customers = outputStorageDTO.getCustomerId().stream()
                .map(customerId -> {
                    Customer customer = new Customer();
                    customer.setCustomerId(customerId);
                    return customer;
                })
                .collect(Collectors.toSet());
        outputStorage.setCustomers(customers);


        return outputStorage;
    }
}
