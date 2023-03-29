package com.ii.microservices.beerservice.entities;

import com.ii.microservices.beerservice.models.BeerStyleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar",updatable = false,nullable = false)
    private UUID id;
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
