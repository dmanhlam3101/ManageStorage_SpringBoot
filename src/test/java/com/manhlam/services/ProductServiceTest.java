package com.manhlam.services;

import com.manhlam.dtos.ProductDTO;
import com.manhlam.dtos.ProductRequestDTO;
import com.manhlam.dtos.UnitDTO;
import com.manhlam.models.Product;
import com.manhlam.models.Supplier;
import com.manhlam.models.Unit;
import com.manhlam.repositories.ProductRepository;
import com.manhlam.repositories.SupplierRepository;
import com.manhlam.repositories.UnitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private UnitRepository unitRepository;
    @Mock
    private SupplierRepository supplierRepository;

    ProductDTO productDTO = new ProductDTO(1,"product 1", true,new Unit(),new Supplier());
    @Test
    void getAllProducts() {
        Unit unit = new Unit(1, "Test Unit", true);
        Supplier supplier = new Supplier(1, "Test Supplier", "Test Address", "123456", "test@example.com", "Info", null, true);
        Product product1 = new Product(1, "Product 1", unit, supplier, true, null);
        Product product2 = new Product(2, "Product 2", unit, supplier, true, null);

        // Mock the behavior of productRepository.findAll()
        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        // Act
        List<ProductDTO> result = productService.getAllProducts();

        // Assert
        assertThat(result).isNotNull().hasSize(2);
        assertEquals(product1.getProductId(), result.get(0).getProductId());
        assertEquals(product1.getProductName(), result.get(0).getProductName());
        assertEquals(product1.isStatus(), result.get(0).isStatus());
        assertEquals(unit, result.get(0).getUnit());
        assertEquals(supplier, result.get(0).getSupplier());
    }

    @Test
    void getProductById() {
    }

    @Test
    void addProduct() {

        Integer unitId = 1;
        Unit unit = new Unit(unitId, "Unit 1", true);

        // Mock the behavior of unitRepository.findByUnitId()
        Mockito.when(unitRepository.findByUnitId(unitId)).thenReturn(Optional.of(unit));

        // Create a Supplier instance
        Integer supplierId = 1;
        Supplier supplier = new Supplier(supplierId, "Supplier 1","Ha noi",
                "123456","supplier1@gmail.com","info",new Date(2022-01-01),true);

        Mockito.when(supplierRepository.findBySupplierId(supplierId)).thenReturn(Optional.of(supplier));
        // Create a ProductRequestDTO instance
        Integer productId = 1;
        ProductRequestDTO productRequestDTO = new ProductRequestDTO(productId, "product 1", true, unitId, supplierId);

        // Create a Product instance
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName("product 1");
        product.setStatus(true);
        product.setUnit(unit);
        product.setSupplier(supplier);

        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        // Call the actual addProduct method
        ProductDTO result = productService.addProduct(productRequestDTO);

        Mockito.verify(unitRepository, Mockito.times(1)).findByUnitId(unitId);


        Mockito.verify(supplierRepository, Mockito.times(1)).findBySupplierId(supplierId);

        Mockito.verify(productRepository, Mockito.times(1)).save(Mockito.any(Product.class));

        // Assert that the result has the expected productId
        assertThat(result.getProductId()).isEqualTo(productId);
        assertEquals(result.getProductName(), product.getProductName());
        assertEquals(result.isStatus(), product.isStatus());
        assertEquals(result.getUnit(), product.getUnit());
        assertEquals(result.getSupplier(), product.getSupplier());
    }

    @Test
    void eidtProduct() {
    }

    @Test
    void deleteProduct() {
    }
}