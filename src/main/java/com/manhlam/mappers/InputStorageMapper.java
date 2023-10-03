package com.manhlam.mappers;

import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.models.InputStorage;
import com.manhlam.models.Product;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputStorageMapper {

    public static InputStorageDTO toDto(InputStorage inputStorage) {
        InputStorageDTO inputStorageDTO = new InputStorageDTO();
        inputStorageDTO.setInputId(inputStorage.getInputId());
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

    public static List<InputStorageDTO> toDtoList(List<InputStorage> inputStorages) {
        return inputStorages.stream().map(InputStorageMapper::toDto).collect(Collectors.toList());
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
