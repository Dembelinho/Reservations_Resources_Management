package com.sdia.reservationsservice.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReservationDto {
    private String name;
    private String context;
    private Long Duration;
    private Long idPerson;
    private Long resourceId;
}
