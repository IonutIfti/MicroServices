package com.ii.microservices.brewery.services.impl;

import com.ii.microservices.brewery.models.CustomerDTO;
import com.ii.microservices.brewery.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        return CustomerDTO.builder()
                .id(1278857254L)
                .firstName("Johny")
                .lastName("Wicker")
                .email("wick@gmail.com")
                .age(23)
                .build();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        log.info("Getting all customers");
        return null;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customer) {
        log.info("Created customer with ID: {}",customer.getId());
        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .age(customer.getAge())
                .build();
    }

    @Override
    public void updateCustomer(Long customerId, CustomerDTO customer) {
        log.info("Updated customer with ID: {}",customerId);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        log.info("Deleted customer with ID: {}",customerId);

    }
}
