package com.ii.microservices.brewery.models;

import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;

}
