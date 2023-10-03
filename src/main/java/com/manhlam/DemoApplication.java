package com.manhlam;

import com.manhlam.repositories.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class DemoApplication {
    private final CustomerRepository customerRepository;

    public DemoApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

//    @GetMapping
//    public List<Customer> getCustomers() {
//        return customerRepository.findAll();
//    }
//
//    @PostMapping
//    public void addCustomer(@RequestBody CustomerDAO customerDAO) {
//        Customer customer = new Customer();
//        customer.setName(customerDAO.getName());
//        customer.setAge(customerDAO.getAge());
//        customer.setEmail(customerDAO.getEmail());
//
//        customerRepository.save(customer);
//    }
//
//    @PutMapping("{customerId}")
//    public void editCustomer(@PathVariable Integer customerId, @RequestBody CustomerDAO customerDAO) {
//
//		Optional<Customer> customerExist = customerRepository.findById(customerId);
//        if(customerExist.isPresent()){
//            Customer customer = customerExist.get();
//            customer.setName(customerDAO.getName());
//            customer.setEmail(customerDAO.getEmail());
//            customer.setAge(customerDAO.getAge());
//
//            customerRepository.save(customer);
//        }
//
//    }
//
//    @DeleteMapping("{customerId}")
//    public void deleteCustomer(@PathVariable Integer customerId) {
//
//        customerRepository.deleteById(customerId);
//
//    }
}
