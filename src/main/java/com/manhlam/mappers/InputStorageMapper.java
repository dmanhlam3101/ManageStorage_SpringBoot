package com.manhlam.mappers;

import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.InputStorageResponseDTO;
import com.manhlam.dtos.ProductDTO;
import com.manhlam.models.InputStorage;
import com.manhlam.models.Product;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputStorageMapper {

    public static InputStorageDTO toDto(InputStorage inputStorage) {
        InputStorageDTO inputStorageDTO = new InputStorageDTO();
        //inputStorageDTO.setInputId(inputStorage.getInputId());
        Set<Integer> productIds = inputStorage.getProducts().stream()
                .map(Product::getProductId)
                .collect(Collectors.toSet());
        inputStorageDTO.setProductId(productIds);
        inputStorageDTO.setQuantity(inputStorage.getQuantity());
        inputStorageDTO.setDateInput(inputStorage.getDateInput());
        inputStorageDTO.setInputPrice(inputStorage.getInputPrice());
        inputStorageDTO.setOutputPrice(inputStorage.getOutputPrice());
        inputStorageDTO.setStatus(inputStorage.getStatus());
        return inputStorageDTO;
    }
    public static InputStorageResponseDTO toDtoResponse(InputStorage inputStorage) {
        InputStorageResponseDTO inputStorageDTO = new InputStorageResponseDTO();
        inputStorageDTO.setInputId(inputStorage.getInputId());

        Set<ProductDTO> products = inputStorage.getProducts().stream()
                .map(product -> new ProductDTO(
                        product.getProductId(),
                        product.getProductName(),
                        product.isStatus(),
                        product.getUnit(),
                        product.getSupplier()

                ))
                .collect(Collectors.toSet());
        inputStorageDTO.setProduct(products);
        inputStorageDTO.setQuantity(inputStorage.getQuantity());
        inputStorageDTO.setDateInput(inputStorage.getDateInput());
        inputStorageDTO.setInputPrice(inputStorage.getInputPrice());
        inputStorageDTO.setOutputPrice(inputStorage.getOutputPrice());
        inputStorageDTO.setStatus(inputStorage.getStatus());
        return inputStorageDTO;
    }

    public static List<InputStorageDTO> toDtoList(List<InputStorage> inputStorages) {
        return inputStorages.stream().map(InputStorageMapper::toDto).collect(Collectors.toList());
    }
    public static List<InputStorageResponseDTO> toDtoResponseList(List<InputStorage> inputStorages) {
        return inputStorages.stream().map(InputStorageMapper::toDtoResponse).collect(Collectors.toList());
    }
    public static InputStorage toEntity(InputStorageDTO inputStorageDTO) {
        InputStorage inputStorage = new InputStorage();
        inputStorage.setInputId(inputStorageDTO.getInputId());

        // Assuming there's a method to fetch products by productIds
        Set<Product> products = inputStorageDTO.getProductId().stream()
                .map(productId -> {
                    Product product = new Product();
                    product.setProductId(productId);
                    return product;
                })
                .collect(Collectors.toSet());

        inputStorage.setProducts(products);
        inputStorage.setQuantity(inputStorageDTO.getQuantity());
        inputStorage.setDateInput(inputStorageDTO.getDateInput());
        inputStorage.setInputPrice(inputStorageDTO.getInputPrice());
        inputStorage.setOutputPrice(inputStorageDTO.getOutputPrice());
        inputStorage.setStatus(inputStorageDTO.getStatus());

        return inputStorage;
    }

    public static List<InputStorage> toEntityList(List<InputStorageDTO> inputStorageDTOs) {
        return inputStorageDTOs.stream().map(InputStorageMapper::toEntity).collect(Collectors.toList());
    }
//    public static List<InputStorageDTO> mapListInputStoragesToDTO(Collection<InputStorage> inputStorages) {
//        if (inputStorages == null || inputStorages.isEmpty()) {
//            return Collections.emptyList();
//        }
//        return inputStorages.stream()
//                .map(InputStorageMapper::toDto)
//                .collect(Collectors.toList());
//    }
}
