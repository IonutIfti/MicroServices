package com.ii.microservices.brewery.bootstrap;

import com.ii.microservices.brewery.entity.Beer;
import com.ii.microservices.brewery.repositories.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository  beerRepository;
    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects(){
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                            .beerName("Mango Pip")
                            .beerStyle("IPA")
                            .minOnHand(12)
                            .quantityToBrew(200)
                            .upc(2193489182599L)
                            .price(new BigDecimal("13.49"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Chin Chin")
                    .beerStyle("Lagger")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(21933477182599L)
                    .price(new BigDecimal("11.49"))
                    .build());
        }
    }
}
