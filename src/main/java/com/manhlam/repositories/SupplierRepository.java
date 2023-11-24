package com.manhlam.repositories;

import com.manhlam.models.Supplier;
import com.manhlam.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

    public Optional<Supplier> findBySupplierId(int supplierId);
}
