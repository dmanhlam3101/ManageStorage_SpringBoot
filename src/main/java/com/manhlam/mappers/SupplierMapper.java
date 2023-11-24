package com.manhlam.mappers;

import com.manhlam.dtos.SupplierDTO;
import com.manhlam.dtos.UnitDTO;
import com.manhlam.models.Supplier;
import com.manhlam.models.Unit;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierMapper {
    public static SupplierDTO toDTO(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplierId(supplier.getSupplierId());
        supplierDTO.setAddress(supplier.getAddress());
        supplierDTO.setContractDate(supplier.getContractDate());
        supplierDTO.setDisplayName(supplier.getDisplayName());
        supplierDTO.setEmail(supplier.getEmail());
        supplierDTO.setMoreInfo(supplier.getMoreInfo());
        supplierDTO.setPhone(supplier.getPhone());
        supplierDTO.setStatus(supplier.getStatus());
        return supplierDTO;
    }
    public static List<SupplierDTO> toDtoList(List<Supplier> supplierList) {
        return supplierList.stream().map(SupplierMapper::toDTO).collect(Collectors.toList());
    }

}
