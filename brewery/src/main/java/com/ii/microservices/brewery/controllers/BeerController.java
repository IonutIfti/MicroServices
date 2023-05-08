package com.ii.microservices.brewery.controllers;

import com.ii.microservices.brewery.models.BeerDTO;
import com.ii.microservices.brewery.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/beer")
@AllArgsConstructor
public class BeerController {
    private final BeerService beerService;
    @GetMapping("/beers")
    public ResponseEntity<List<BeerDTO>> getAllBeers(){
        return new ResponseEntity<>(beerService.getAllBeers(), HttpStatus.OK);
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable(name = "beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping("/createBeer")
    public ResponseEntity<Object> createBeer(@RequestBody BeerDTO beerDTO){
        BeerDTO freshBeer = beerService.saveFreshBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", freshBeer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/updateBeer/{beerId}")
    public ResponseEntity<Object> updateBeer(@RequestBody BeerDTO beerDTO,
                                             @PathVariable(name = "beerId")UUID beerId){
        beerService.updateBeer(beerId,beerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteBeer/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable(name="beerId")UUID beerId){
        beerService.deleteBeer(beerId);
    }
}
