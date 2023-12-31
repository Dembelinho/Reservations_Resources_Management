package com.sdia.resourcesservice.Dtos;

import lombok.*;

@AllArgsConstructor // pour générer un constructeur avec tous les arguments
@NoArgsConstructor // pour générer un constructeur sans arguments
@Builder // pour générer un builder
@ToString // pour générer la méthode toString()
@Getter // pour générer les getters
@Setter // pour générer les setters
public class ResourceClient {
    private String name;
    private String type;
}
