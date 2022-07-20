package com.shaquib.crud.service;

import com.shaquib.crud.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();  // for getting list of customer from database

    Customer saveCustomer(Customer customer);   // to save in database

    /**
     * Customer by id customer.
     *
     * @param id the id
     * @return the customer
     */
    Customer customerById(Long id);//to fetch by customer by id

    Customer updateCustomer(Long CustomerId, Customer customer);

    ResponseEntity<String> removeCustomer(Long customerId);
}
