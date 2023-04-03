package com.ii.microservices.brewery.services.impl;

import com.ii.microservices.brewery.entity.Beer;
import com.ii.microservices.brewery.entity.Customer;
import com.ii.microservices.brewery.mappers.BeerMapper;
import com.ii.microservices.brewery.mappers.CustomerMapper;
import com.ii.microservices.brewery.models.BeerDTO;
import com.ii.microservices.brewery.models.CustomerDTO;
import com.ii.microservices.brewery.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@AllArgsConstructor

public class BeerServiceImpl implements BeerService {
    private final BeerMapper beerMapper;
    private final CustomerMapper customerMapper;
    public void getMad(BeerDTO beerDTO){
        Beer beer = beerMapper.beerDTOToBeer(beerDTO);
    }

    public void getBb(CustomerDTO customerDTO){
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
    }


    @Override
    public BeerDTO getBeerById(Long beerId) {
        log.info("Found beer with ID: {}", beerId);
        return BeerDTO.builder()
                .id(1823748L)
                .beerName("Swart")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDTO saveFreshBeer(BeerDTO beerDTO) {
        log.info("Created fresh beer with ID: {}",beerDTO.getId());
        return BeerDTO.builder()
                .id(beerDTO.getId())
                .beerName(beerDTO.getBeerName())
                .beerStyle(beerDTO.getBeerStyle())
                .upc(beerDTO.getUpc())
                .build();
    }

    @Override
    public void updateBeer(Long beerId, BeerDTO beerDTO) {
        log.info("Found beer with ID: {}",beerId);
        log.info("Updated beer with ID: {}",beerDTO.getId());
    }
    @Override
    public void deleteBeer(Long beerId) {
        log.info("Found beer with ID: {}",beerId);
        log.info("Deleted beer with ID: {}",beerId);
    }

    @Override
    public List<BeerDTO> getAllBeers() {
        return null;
    }
}
