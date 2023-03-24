package com.ii.microservices.brewery.models;

import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
