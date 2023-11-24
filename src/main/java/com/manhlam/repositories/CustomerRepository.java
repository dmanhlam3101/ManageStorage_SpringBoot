package com.manhlam.repositories;

import com.manhlam.models.Customer;
import com.manhlam.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByCustomerIdIn(Set<Integer> customerIds);

}
