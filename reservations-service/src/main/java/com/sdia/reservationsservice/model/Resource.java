package com.sdia.reservationsservice.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Resource {
    private Long id;
    private String name;
    private String type;
}
