package com.ii.microservices.brewery.services;

import com.ii.microservices.brewery.models.BeerDTO;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveFreshBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteBeer(UUID beerId);
    List<BeerDTO> getAllBeers();
}

