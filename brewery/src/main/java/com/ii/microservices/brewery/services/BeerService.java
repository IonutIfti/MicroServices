package com.ii.microservices.brewery.services;

import com.ii.microservices.brewery.models.BeerDTO;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(Long beerId);

    BeerDTO saveFreshBeer(BeerDTO beerDTO);

    void updateBeer(Long beerId, BeerDTO beerDTO);

    void deleteBeer(Long beerId);
    List<BeerDTO> getAllBeers();
}

