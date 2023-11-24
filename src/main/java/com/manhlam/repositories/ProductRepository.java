package com.manhlam.repositories;

import com.manhlam.dtos.ProductDTO;
import com.manhlam.models.Product;
import com.manhlam.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product as p  where p.status != false")
    List<Product>  findAll();

     Optional<Product> findByProductId(int productId);

    List<Product> findByProductIdIn(Set<Integer> productIds);
}
