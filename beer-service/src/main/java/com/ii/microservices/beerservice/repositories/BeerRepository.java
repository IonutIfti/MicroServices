package com.ii.microservices.beerservice.repositories;

import com.ii.microservices.beerservice.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}
