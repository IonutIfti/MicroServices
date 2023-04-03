package com.ii.microservices.brewery.services;

import com.ii.microservices.brewery.models.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(Long customerId);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO createCustomer(CustomerDTO customer);

    void updateCustomer(Long customerId, CustomerDTO customer);

    void deleteCustomer(Long customerId);
}
