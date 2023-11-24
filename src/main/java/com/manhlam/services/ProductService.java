package com.manhlam.services;

import com.manhlam.dtos.ProductDTO;
import com.manhlam.dtos.ProductRequestDTO;
import com.manhlam.exceptions.ApiException;
import com.manhlam.exceptions.NotFoundExeption;
import com.manhlam.mappers.ProductMapper;
import com.manhlam.models.Supplier;
import com.manhlam.models.Unit;
import com.manhlam.repositories.ProductRepository;
import com.manhlam.repositories.SupplierRepository;
import com.manhlam.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    public ProductService(ProductRepository productRepository, UnitRepository unitRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.unitRepository = unitRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<ProductDTO> getAllProducts() {
        return ProductMapper.toDtoList(this.productRepository.findAll());
    }

    public ProductDTO getProductById(int productId) {
        ProductDTO productDTO = ProductMapper.toDto(productRepository.findByProductId(productId)
                .orElseThrow(() -> new NotFoundExeption("Product with productId: " + productId + " Not Found")));
        return productDTO;
    }

    public ProductDTO addProduct(ProductRequestDTO productRequestDto) {
        Unit unit = unitRepository.findByUnitId(productRequestDto.getUnitId())
                .orElseThrow(() -> new NotFoundExeption("Unit with Id" +productRequestDto.getUnitId()+"not found"));
        Supplier supplier = supplierRepository.findBySupplierId(productRequestDto.getSupplierId())
                .orElseThrow(() -> new NotFoundExeption("Supplier with Id" +productRequestDto.getSupplierId()+"not found"));
        try {
            return (ProductMapper.toDto(productRepository.save(ProductMapper.toEntity(productRequestDto,unit,supplier))));
        } catch (Exception ex) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Service failed unexpectedly");
        }
    }
    public ProductDTO eidtProduct (int productId , ProductRequestDTO productDTO){
        ProductDTO product = ProductMapper.toDto(productRepository.findByProductId(productId)
                .orElseThrow(() -> new NotFoundExeption("Product with id"+productId+"not found")));

        Unit unit = unitRepository.findByUnitId(productDTO.getUnitId())
                .orElseThrow(() -> new NotFoundExeption("Unit with Id" +productDTO.getUnitId()+"not found"));
        Supplier supplier = supplierRepository.findById(productDTO.getSupplierId())
                .orElseThrow(() -> new NotFoundExeption("Supplier with Id" +productDTO.getSupplierId()+"not found"));
        if(product != null){
            product.setProductName(productDTO.getProductName());
            product.setStatus(productDTO.isStatus());
            product.setUnit(unit);
            product.setSupplier(supplier);
        }
        try {
            return ProductMapper.toDto(productRepository.save(ProductMapper.toEntity(product)));

        }catch (Exception ex){
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR , "Service failed unexpectedly");
        }
    }

    public ProductDTO deleteProduct(int productId) {
        ProductDTO productDTO = ProductMapper.toDto(productRepository.findByProductId(productId)
                .orElseThrow(() -> new NotFoundExeption("Product with productId: " + productId + " Not Found")));
        if (productDTO != null) {
            productDTO.setStatus(false);
            return ProductMapper.toDto(productRepository.save(ProductMapper.toEntity(productDTO)));
        }
        return null;
    }
}
