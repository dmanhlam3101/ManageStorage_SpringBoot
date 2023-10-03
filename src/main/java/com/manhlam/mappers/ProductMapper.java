package com.manhlam.mappers;

import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.dtos.ProductDTO;
import com.manhlam.models.InputStorage;
import com.manhlam.models.Product;

import java.util.List;
import java.util.stream.Collectors;

import static com.manhlam.mappers.SupplierMapper.mapSupplierToDTO;
import static com.manhlam.mappers.UnitMapper.mapUnitToDTO;

public class ProductMapper {
    public static ProductDTO toDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setStatus(product.isStatus());
        productDTO.setUnit(mapUnitToDTO(product.getUnitId())); // Map Unit to UnitDTO
        productDTO.setSupplier(mapSupplierToDTO(product.getSupplierId()));
        List<InputStorageDTO> inputStorageDTOs = InputStorageMapper.toDtoList((List<InputStorage>) product.getInputStorages());
        productDTO.setInputStorages(inputStorageDTOs);
        return productDTO;
    }






    public static List<ProductDTO> toDtoList(List<Product> entities) {
        return entities.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

//    public static List<ProductDTO> toDtoList(Iterable<Product> entities) {
//        List<ProductDTO> productDTOS = new LinkedList<>();
//        entities.forEach(e -> productDTOS.add(ProductMapper::toDto(e)));
//        return productDTOS;
//    }
}
