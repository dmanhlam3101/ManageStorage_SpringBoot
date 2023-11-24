package com.manhlam.repositories;

import com.manhlam.dtos.UnitDTO;
import com.manhlam.models.Product;
import com.manhlam.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit,Integer> {

    List<Unit> findAll();
    public Optional<Unit> findByUnitId(int unitId);

    //public Optional<UnitDTO> findByUnitDTOId(int unitId);
}
