package com.manhlam.repositories;

import com.manhlam.models.InputStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InputStorageRepository extends JpaRepository<InputStorage,Integer> {

    @Query("select i from InputStorage  as i join  i.products as p where  p.productId= ?1")
    public List<InputStorage> findAllByProductId(Integer id);
    @Query("select i from InputStorage  as i join  i.products ")
    public List<InputStorage> getAll();
}
