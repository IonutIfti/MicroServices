package com.ii.microservices.limitservice.controllers;

import com.ii.microservices.limitservice.bean.Limits;
import com.ii.microservices.limitservice.config.Config;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LimitController {

    private final Config config;

    @GetMapping("/limits")
    public Limits retrieveLimits(){
       return new Limits(config.getMin(), config.getMax());
    };
}
