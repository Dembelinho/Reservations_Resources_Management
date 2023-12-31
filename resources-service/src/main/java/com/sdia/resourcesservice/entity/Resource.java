package com.sdia.resourcesservice.entity;

import com.sdia.resourcesservice.enums.ResourceType;
import jakarta.persistence.*;
import lombok.*;

@Entity @ToString @Builder @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ResourceType type;
}
