package com.shaquib.crud.controller;

import com.shaquib.crud.entity.Customer;
import com.shaquib.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController   // the first thing user hit like waiter in restaurant
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired   // auto write of 2nd part (dependency injection)
    private CustomerService customerService;



    /**
     * Get all customers response entity.
     *
     * @param age the age for filter
     * @return the response entity
     */
    @GetMapping("/customers")  // endpoint 1
    public ResponseEntity<List<Customer>> getAllCustomers(Integer age){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    /**
     * Gets customer by id.
     *
     * @param customerId the id
     * @return the customer by id
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId){
        return  new ResponseEntity<>(customerService.customerById(customerId), HttpStatus.OK);

    }

    /**
     * Save customer response entity.
     *
     * @param customer the customer
     * @return the response entity
     */
    @PostMapping("/customer")
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
        System.out.println(customer.toString());
       Customer cus = customerService.saveCustomer(customer);
       if(Objects.nonNull(cus)){
           return new ResponseEntity<>("customer saved successfully customer id = " + cus.getId() ,HttpStatus.CREATED);
       }
       return new ResponseEntity<>("customer not saved", HttpStatus.BAD_REQUEST);
    }

    /**
     * Update customer response entity.
     *
     * @param customerId the customer id
     * @param customer   the customer
     * @return the response entity
     */
    @PutMapping("/customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId,@RequestBody Customer customer ){
        return new ResponseEntity<>(customerService.updateCustomer(customerId,customer),HttpStatus.OK);
    }

    /**
     * Delete course response entity.
     *
     * @param customerId the customer id
     * @return the response entity
     */
    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long customerId){
        return customerService.removeCustomer(customerId);
    }


}
