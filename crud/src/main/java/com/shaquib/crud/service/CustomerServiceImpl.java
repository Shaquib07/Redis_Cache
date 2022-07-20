package com.shaquib.crud.service;

import com.shaquib.crud.entity.Customer;
import com.shaquib.crud.exception.CustomerBusinessException;
import com.shaquib.crud.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private static final String REDIS_CACHE_NAME="customer";

    @Autowired
    private RedisCacheManager cacheManager;


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Cacheable(value = REDIS_CACHE_NAME)
    public List<Customer> getAllCustomers() {
        log.info("fetching data from from DB ");
        return customerRepository.findAll();
    }

    @Override
    @CachePut(value = REDIS_CACHE_NAME,key = "#customer.id")
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Cacheable(value = REDIS_CACHE_NAME,key = "#id")
    public Customer customerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerBusinessException("Id doesn't exits "+ id));

    }

    @Override
    @CachePut(value = REDIS_CACHE_NAME,key = "#id")
    public Customer updateCustomer(Long id, Customer customer) {
       Customer entity= customerRepository.findById(id)
               .orElseThrow(()-> new CustomerBusinessException("Id not present"));
       entity.setUsername(customer.getUsername());
       entity.setAge(customer.getAge());
       entity.setFirstname(customer.getFirstname());
       entity.setLastname(customer.getLastname());
       entity.setEmail(customer.getEmail());
       entity.setPhone(customer.getPhone());
       entity.setEnabled(customer.isEnabled());
       entity.setEmailVerified(customer.isEmailVerified());
       entity.setPhoneVerified(customer.isPhoneVerified());
       entity.setAddresses(customer.getAddresses());
       return customerRepository.save(entity);
    }

    @Override
    @CacheEvict(value = REDIS_CACHE_NAME,allEntries = true)
    public ResponseEntity<String> removeCustomer(Long customerId) {
      Optional<Customer> customer=customerRepository.findById(customerId);
      if(customer.isPresent()){
          customerRepository.deleteById(customerId);
          return  new ResponseEntity<>("Deleted Successfully !", HttpStatus.OK);
      }
        return new ResponseEntity<>("Customer Id "+customerId+" not Exists ", HttpStatus.NOT_FOUND);
    }
}
