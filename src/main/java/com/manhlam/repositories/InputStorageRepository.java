package com.manhlam.repositories;

import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.models.InputStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InputStorageRepository extends JpaRepository<InputStorage,Integer> {

    @Query("select i from InputStorage  as i join  i.products as p where  p.productId= ?1")
    public List<InputStorage> findAllByProductId(Integer id);
    @Query("SELECT i FROM InputStorage i JOIN i.products p WHERE i.status != false")
    List<InputStorage> getAll();
    Optional<InputStorage> findByInputId(int inputStorageId);
}
