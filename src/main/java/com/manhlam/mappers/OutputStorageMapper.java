package com.manhlam.mappers;

import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.OutputStorageDTO;
import com.manhlam.models.InputStorage;
import com.manhlam.models.OutputStorage;

import java.util.List;
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

    public static List<OutputStorageDTO> toDtoList(List<OutputStorage> outputStorage) {
        return  outputStorage.stream().map(OutputStorageMapper::toDto).collect(Collectors.toList());
    }
}
