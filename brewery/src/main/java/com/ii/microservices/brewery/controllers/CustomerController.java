package com.ii.microservices.brewery.controllers;

import com.ii.microservices.brewery.models.CustomerDTO;
import com.ii.microservices.brewery.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "customerId")UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer){
        CustomerDTO createdCustomer = customerService.createCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", createdCustomer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<Object> updateCustomer(@RequestBody CustomerDTO customer,
                               @PathVariable(name = "customerId")UUID customerId){
        customerService.updateCustomer(customerId,customer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable(name="customerId")UUID customerId){
        customerService.deleteCustomer(customerId);
    }
}
