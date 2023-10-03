package com.manhlam.controllers;

import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.mappers.ProductMapper;
import com.manhlam.models.InputStorage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputStorageMapper {

    public static InputStorageDTO toDto(InputStorage inputStorage) {
        InputStorageDTO inputStorageDTO = new InputStorageDTO();
        inputStorageDTO.setInputId(inputStorage.getInputId());
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
