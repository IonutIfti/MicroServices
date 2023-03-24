package com.ii.microservices.brewery.services.impl;

import com.ii.microservices.brewery.models.CustomerDTO;
import com.ii.microservices.brewery.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Johny")
                .lastName("Wicker")
                .email("wick@gmail.com")
                .age(23)
                .build();
    }
}
