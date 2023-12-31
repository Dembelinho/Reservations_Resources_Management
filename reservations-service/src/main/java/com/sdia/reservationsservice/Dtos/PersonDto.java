package com.sdia.reservationsservice.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonDto {
    private String name;
    private String email;
    private String function;
}
