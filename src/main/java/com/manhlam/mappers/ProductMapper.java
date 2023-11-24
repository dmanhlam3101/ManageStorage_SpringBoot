package com.manhlam.mappers;

import com.manhlam.dtos.ProductDTO;
import com.manhlam.dtos.ProductRequestDTO;
import com.manhlam.models.Product;
import com.manhlam.models.Supplier;
import com.manhlam.models.Unit;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductDTO toDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setStatus(product.isStatus());
        productDTO.setUnit(product.getUnitId()); // Map Unit to UnitDTO
        productDTO.setSupplier(product.getSupplierId());
//        List<InputStorageDTO> inputStorageDTOs = InputStorageMapper.toDtoList((List<InputStorage>) product.getInputStorages());
//        productDTO.setInputStorages(inputStorageDTOs);
        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setStatus(productDTO.isStatus());
        if(Objects.nonNull(productDTO.getUnit())){
            Unit unitEntity = new Unit();
            unitEntity.setUnitId(Objects.requireNonNull(productDTO.getUnit().getUnitId(), "Unit ID is required!"));
            product.setUnitId(unitEntity);
        }
        if(Objects.nonNull(productDTO.getSupplier())){
            Supplier supplierEntity = new Supplier();
            supplierEntity.setSupplierId(Objects.requireNonNull(productDTO.getSupplier().getSupplierId(), "Supllier ID is required!"));
            product.setSupplierId(supplierEntity);
        }
//        List<InputStorage> inputStorages = InputStorageMapper.toEntityList(productDTO.getInputStorages());
//        product.setInputStorages(inputStorages);

        return product;
    }
    public static Product toEntity(ProductRequestDTO productRequestDto, Unit unit , Supplier supplier) {
        Product product = new Product();
        //product.setProductId(productRequestDto.getProductId());
        product.setProductName(productRequestDto.getProductName());
        product.setStatus(productRequestDto.isStatus());
        product.setUnitId(unit);
        product.setSupplierId(supplier);

        return product;
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
