package com.ii.microservices.brewery.services;

import com.ii.microservices.brewery.models.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);
}
