package com.ii.microservices.brewery.mappers;

import com.ii.microservices.brewery.entity.Beer;
import com.ii.microservices.brewery.models.BeerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BeerMapper {
    BeerDTO beerToBeerDTO(Beer beer);
    Beer beerDTOToBeer(BeerDTO beerDTO);
}
