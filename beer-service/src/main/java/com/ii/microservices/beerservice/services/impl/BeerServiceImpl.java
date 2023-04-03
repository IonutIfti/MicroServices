package com.ii.microservices.beerservice.services.impl;

import com.ii.microservices.beerservice.entities.Beer;
import com.ii.microservices.beerservice.mappers.BeerMapper;
import com.ii.microservices.beerservice.models.BeerDTO;
import com.ii.microservices.beerservice.repositories.BeerRepository;
import com.ii.microservices.beerservice.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BeerServiceImpl implements BeerService {

    private final BeerMapper beerMapper;

    private final BeerRepository beerRepository;
    @Autowired
    public BeerServiceImpl(BeerMapper beerMapper, BeerRepository beerRepository) {
        this.beerMapper = beerMapper;
        this.beerRepository = beerRepository;
    }


    @Override
    public BeerDTO createBeer(BeerDTO beerDTO) {
        Beer beer = beerMapper.mapToEntity(beerDTO);
        Beer newBeer = beerRepository.save(beer);
        return beerMapper.mapToDTO(newBeer);
    }
}
