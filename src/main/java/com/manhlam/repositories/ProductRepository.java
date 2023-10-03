package com.manhlam.repositories;

import com.manhlam.dtos.ProductDTO;
import com.manhlam.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p JOIN FETCH p.inputStorages")
    List<ProductDTO>  get();
}
