package com.manhlam.controllers;

import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.UnitDTO;
import com.manhlam.models.InputStorage;
import com.manhlam.models.Unit;

import java.util.List;
import java.util.stream.Collectors;

public class UnitMapper {
    public static UnitDTO mapUnitToDTO(Unit unit) {
        if (unit == null) {
            return null;
        }
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setUnitId(unit.getUnitId());
        unitDTO.setUnitName(unit.getUnitName());
        unitDTO.setStatus(unit.getStatus());
        return unitDTO;
    }
    public static List<UnitDTO> toDtoList(List<Unit> unitList) {
        return unitList.stream().map(UnitMapper::mapUnitToDTO).collect(Collectors.toList());
    }
}
