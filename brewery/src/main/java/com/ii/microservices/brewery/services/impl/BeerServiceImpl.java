package com.ii.microservices.brewery.services.impl;

import com.ii.microservices.brewery.models.BeerDTO;
import com.ii.microservices.brewery.services.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        log.info("Found beer with ID: {}", beerId);
        return BeerDTO.builder()
                .id(UUID.randomUUID())
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
}
