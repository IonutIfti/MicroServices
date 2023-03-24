package com.ii.microservices.brewery.controllers;

import com.ii.microservices.brewery.models.BeerDTO;
import com.ii.microservices.brewery.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/beer")
@AllArgsConstructor
public class BeerController {
    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable(name = "beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createBeer(@RequestBody BeerDTO beerDTO){
        BeerDTO freshBeer = beerService.saveFreshBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", freshBeer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
