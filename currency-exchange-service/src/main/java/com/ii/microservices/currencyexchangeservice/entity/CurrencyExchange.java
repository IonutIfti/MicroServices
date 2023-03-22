package com.ii.microservices.currencyexchangeservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")

    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
