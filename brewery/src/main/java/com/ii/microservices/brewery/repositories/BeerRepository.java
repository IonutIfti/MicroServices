package com.ii.microservices.brewery.repositories;

import com.ii.microservices.brewery.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
