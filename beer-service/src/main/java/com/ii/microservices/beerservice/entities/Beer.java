package com.ii.microservices.beerservice.entities;

import com.ii.microservices.beerservice.models.BeerStyleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private Integer version;
    @NotBlank
    private OffsetDateTime createdDate;
    @NotBlank
    private OffsetDateTime lastModifiedDate;
    @NotBlank
    private String beerName;
    @NotBlank
    private BeerStyleEnum beerStyle;
    @NotBlank
    @Positive
    private Long upc;
    @Positive
    private BigDecimal price;
    @Positive
    private Integer quantityOnHand;
}
