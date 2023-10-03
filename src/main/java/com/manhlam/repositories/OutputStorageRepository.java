package com.manhlam.repositories;


import com.manhlam.models.OutputStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OutputStorageRepository extends JpaRepository<OutputStorage,Integer> {
    @Query("select o from OutputStorage  as o join  o.products as p where  p.productId= ?1")
    public List<OutputStorage> findAllByProductId(Integer id);
}
