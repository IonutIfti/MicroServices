package com.ii.microservices.currencyconversionservice.controllers;

import com.ii.microservices.currencyconversionservice.models.CurrencyConversion;
import com.ii.microservices.currencyconversionservice.proxies.CurrencyExchangeProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@AllArgsConstructor
public class CurrencyConversionController {
    private final CurrencyExchangeProxy currencyExchangeProxy;
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversion> calculateCurrencyConversion(@PathVariable(name="from")String from,
                                                                          @PathVariable(name = "to")String to,
                                                                          @PathVariable(name = "quantity")BigDecimal quantity){
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);


        ResponseEntity<CurrencyConversion> responseEntity= new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, uriVariables);

        CurrencyConversion currencyConversion = responseEntity.getBody();
        assert currencyConversion != null;
        CurrencyConversion currentCurrencyConversion = CurrencyConversion.builder()
                .id(currencyConversion.getId())
                .from(from)
                .to(to)
                .quantity(quantity)
                .conversionMultiple(currencyConversion.getConversionMultiple())
                .totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
                .environment(currencyConversion.getEnvironment())
                .build();
        return new ResponseEntity<>(currentCurrencyConversion, HttpStatus.OK);
    }
    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversion> calculateCurrencyConversionFeign(@PathVariable(name="from")String from,
                                                                          @PathVariable(name = "to")String to,
                                                                          @PathVariable(name = "quantity")BigDecimal quantity){
        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchange(from, to);
        CurrencyConversion currentCurrencyConversion = CurrencyConversion.builder()
                .id(currencyConversion.getId())
                .from(from)
                .to(to)
                .quantity(quantity)
                .conversionMultiple(currencyConversion.getConversionMultiple())
                .totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
                .environment(currencyConversion.getEnvironment())
                .build();
        return new ResponseEntity<>(currentCurrencyConversion, HttpStatus.OK);
    }
}
