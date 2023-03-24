package com.ii.microservices.brewery.services;

import com.ii.microservices.brewery.models.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveFreshBeer(BeerDTO beerDTO);

}

