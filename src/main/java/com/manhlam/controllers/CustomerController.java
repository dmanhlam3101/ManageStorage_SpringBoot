package com.manhlam.controllers;

import com.manhlam.dtos.CustomerDAO;
import com.manhlam.dtos.ProductDTO;
import com.manhlam.models.Customer;
import com.manhlam.models.Product;
import com.manhlam.models.Unit;
import com.manhlam.repositories.CustomerRepository;
import com.manhlam.repositories.ProductRepository;
import com.manhlam.repositories.UnitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {

    private CustomerRepository customerRepository;
    private UnitRepository unitRepository;
    private ProductRepository productRepository;


    public CustomerController(CustomerRepository customerRepository, UnitRepository unitRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.unitRepository = unitRepository;
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<CustomerDAO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDAO> customerDAOs = new ArrayList<>();

        for (Customer customer : customers) {
            // Convert Customer to CustomerDAO or create a mapping method
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.setCustomerId(customer.getCustomerId());
            customerDAO.setDisplayName(customer.getDisplayName());
            // Set other properties as needed

            customerDAOs.add(customerDAO);
        }

        return customerDAOs;
    }


    @GetMapping("unit")
    public List<Unit> getAllUnit(){
        return  unitRepository.findAll();
    }
}
