package com.ii.microservices.currencyexchangeservice.controllers;

import com.ii.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.ii.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class CurrencyExchangeController {
    private final Environment environment;
    private final CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveExchange(@PathVariable(name = "from") String from,
                                                             @PathVariable(name = "to") String to){
        String port = environment.getProperty("local.server.port");
        assert port != null;
        log.info("Created port {}",port.getClass());
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        currencyExchange.setEnvironment(port);
        return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
    }
}
