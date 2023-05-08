package com.ii.microservices.brewery.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    @Null
    private Long id;
    @NotBlank
    private String beerName;
    @NotBlank
    private String beerStyle;
    @Positive
    private Long upc;
    private Long version;
    private Timestamp createDate;
    private Timestamp lastModifiedDate;
    private BigDecimal price;
    private Integer minOnHand;
    private Integer quantityToBrew;

}
