package com.ii.microservices.apigateway.configs;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfig {
    
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
                .filters(f->f.addRequestHeader("Myheader","MyURI"))
                .uri("http://httpbin.org:80");

        Function<PredicateSpec, Buildable<Route>> routeCurrencyExchange = p -> p.path("/currency-exchange/**")
                .uri("lb://currency-exchange");

        Function<PredicateSpec, Buildable<Route>> routeCurrencyConversion = p -> p.path("/currency-conversion/**")
                .uri("lb://currency-conversion");

        return builder.routes()
                .route(routeFunction)
                .route(routeCurrencyExchange)
                .route(routeCurrencyConversion)
                .build();
    }
}
