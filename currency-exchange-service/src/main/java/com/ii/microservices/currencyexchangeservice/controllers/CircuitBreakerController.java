package com.ii.microservices.currencyexchangeservice.controllers;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {
    @GetMapping("/sample")
    @Retry(name = "default", fallbackMethod = "fallBack")
    public String sample(){
        log.info("Sample Call");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://gretingllll/com", String.class);
        return forEntity.getBody();
    }

    public String fallBack(Exception e){
        return "GET TOT THE CHOPPER!";
    }
}
