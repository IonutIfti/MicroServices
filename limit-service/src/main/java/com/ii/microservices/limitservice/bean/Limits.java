package com.ii.microservices.limitservice.bean;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Limits {
    private Integer min;
    private Integer max;
}
