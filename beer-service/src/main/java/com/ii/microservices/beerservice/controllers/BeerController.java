package com.ii.microservices.beerservice.controllers;

import com.ii.microservices.beerservice.models.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {
    @GetMapping("/beers")
    public ResponseEntity<List<BeerDTO>> getBeers(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable(name="beerId") UUID beerId){
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping("/createBeer")
    public ResponseEntity<BeerDTO> createBeer(@RequestBody BeerDTO beerDTO){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateBeer/{beerId}")
    public ResponseEntity<BeerDTO> updateBeer(@RequestBody BeerDTO beerDTO, @PathVariable(name = "beerId")UUID beerId0){
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteBeer/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable(name = "beerId")UUID beerID){

    }
}
