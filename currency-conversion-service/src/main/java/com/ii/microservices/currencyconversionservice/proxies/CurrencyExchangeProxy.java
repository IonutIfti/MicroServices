package com.ii.microservices.currencyconversionservice.proxies;

import com.ii.microservices.currencyconversionservice.models.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//,url = "localhost:8000"
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveExchange(@PathVariable(name = "from") String from,
                                               @PathVariable(name = "to") String to);
}
