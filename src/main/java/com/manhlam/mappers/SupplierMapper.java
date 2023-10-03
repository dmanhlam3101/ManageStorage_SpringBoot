package com.manhlam.mappers;

import com.manhlam.dtos.SupplierDTO;
import com.manhlam.models.Supplier;

public class SupplierMapper {
    public static SupplierDTO mapSupplierToDTO(Supplier supplier) {
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

}
