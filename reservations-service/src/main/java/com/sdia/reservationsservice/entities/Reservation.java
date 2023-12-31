package com.sdia.reservationsservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdia.reservationsservice.model.Resource;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String context;
    private LocalDate date;
    private Long Duration;
    @Transient
    private Resource resource;
    private Long resourceId;
    @ManyToOne
    private Person person;
}
