package com.ii.microservices.beerservice.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDTO {
    private Long id;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
    private BigDecimal price;
    private Integer quantityOnHand;

}
