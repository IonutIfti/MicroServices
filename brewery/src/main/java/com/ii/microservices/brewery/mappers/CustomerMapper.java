package com.ii.microservices.brewery.mappers;

import com.ii.microservices.brewery.entity.Customer;
import com.ii.microservices.brewery.models.CustomerDTO;
import org.mapstruct.Mapper;


public interface CustomerMapper {
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
