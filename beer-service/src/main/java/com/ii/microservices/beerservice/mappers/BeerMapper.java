package com.ii.microservices.beerservice.mappers;

import com.ii.microservices.beerservice.entities.Beer;
import com.ii.microservices.beerservice.models.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDTO beerToBeerDTO(Beer beer);
    Beer beerDTOToBeer(BeerDTO beerDTO);
}
