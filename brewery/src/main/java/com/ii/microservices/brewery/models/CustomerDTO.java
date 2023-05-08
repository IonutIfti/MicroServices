package com.ii.microservices.brewery.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
