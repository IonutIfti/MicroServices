package com.ii.microservices.beerservice.services;

import com.ii.microservices.beerservice.models.BeerDTO;

public interface BeerService {
    BeerDTO createBeer(BeerDTO beerDTO);
}
