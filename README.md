
# Projet : Reservations_Resources_Management

On souhaite créer une application basée sur une architecture micro-service qui permet de gérer des réservations concernant des ressources.
Chaque réservation concerne une seule ressource. Une **ressource** est définie par son id, son nom, son type (MATERIEL_INFO, MATERIEL_AUDIO_VISUEL). 
Une **réservation** est définie par son id, son nom, son contexte, sa date, sa durée.
Chaque réservation est effectuée par une personne. 
Une **personne** est définie par son id, son nom, son email et sa fonction.

L'application se compose de deux micro services fonctionnels :
- Resources-Service: Gère les ressources.
- Reservations-Service: Gère les réservations effectuées par les personnes.

Les micro services techniques à mettre en oeuvre sont les suivants
- Gateway Service : Basé sur Spring Cloud Gateway.
- Config Service: Basé sur Spring Cloud Config.
- Discovery Service: Basé sur Eureka Server.

Pour l’application, nous avons besoin de développer une frontend web, basé sur **Angular Framework**.
La sécurité de l’application est basée sur **Oauth2 et OIDC avec Keycloak** comme Provider
Pour les micro-services, il faut générer la documentation des web services Restfull en utilisant la spécification **OpenAPIDoc (Swagger)**.
Prévoir aussi des circuit breakers basés sur **Resilience4J** comme solution de fault tolerence.

## architecture technique du projet

![architec](https://github.com/Dembelinho/Reservations_Resources_Management/assets/110602716/5cd4e772-d890-4947-b80f-829aa44a6f89)


## Angular front App
```
C:.                                       
│   .editorconfig
│   .gitignore
│   angular.json
│   Dockerfile
│   package-lock.json
│   package.json
│   tsconfig.app.json
│   tsconfig.json
│   tsconfig.spec.json
│
└───src
    │   favicon.ico
    │   index.html
    │   main.ts
    │   styles.css
    │
    ├───app
    │   │   app-routing.module.ts
    │   │   app.component.css
    │   │   app.component.html
    │   │   app.component.spec.ts
    │   │   app.component.ts
    │   │   app.module.ts
    │   │
    │   ├───guards
    │   │       auth.guard.spec.ts
    │   │       auth.guard.ts
    │   │
    │   ├───persons
    │   │       persons.component.css
    │   └───services
    │           security.service.spec.ts
    │           security.service.ts
    │
    └───assets
            .gitkeep
            silent-check-sso.html
```
## Config Service
```
C:.
│   .gitignore
│   Dockerfile
│   mvnw
│   mvnw.cmd
│   pom.xml
│   
├───.mvn
│   └───wrapper
│           maven-wrapper.jar       
│           maven-wrapper.properties
│
└───src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───sdia
    │   │           └───configservice
    │   │                   ConfigServiceApplication.java
    │   │
    │   └───resources
    │           application.properties
    │
    └───test
        └───java
            └───com
                └───sdia
                    └───configservice
                            ConfigServiceApplicationTests.java
```
## Discovery Service
```
C:.
│   .gitignore
│   Dockerfile
│   mvnw
│   mvnw.cmd
│   pom.xml
│   
├───.mvn
│   └───wrapper
│           maven-wrapper.jar
│           maven-wrapper.properties      
│
└───src
    ├───main
    │   ├───java        
    │   │   └───com     
    │   │       └───sdia
    │   │           └───discoveryservice
    │   │                   DiscoveryServiceApplication.java
    │   │
    │   └───resources
    │           application.properties
    │
    └───test
        └───java
            └───com
                └───sdia
                    └───discoveryservice
                            DiscoveryServiceApplicationTests.java
```
## Gateway Service
```
C:.
│   .gitignore
│   Dockerfile
│   mvnw
│   mvnw.cmd
│   pom.xml
│   
├───.mvn
│   └───wrapper
│           maven-wrapper.jar       
│           maven-wrapper.properties
│
└───src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───sdia
    │   │           └───gatewayservice
    │   │                   GatewayServiceApplication.java
    │   │
    │   └───resources
    │           application.properties
    │
    └───test
        └───java
            └───com
                └───sdia
                    └───gatewayservice
                            GatewayServiceApplicationTests.java
```
## Reservations Service 
```
C:.
│   .gitignore
│   Dockerfile
│   mvnw
│   mvnw.cmd
│   pom.xml
│   
├───.mvn
│   └───wrapper
│           maven-wrapper.jar
│           maven-wrapper.properties      
│
└───src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───sdia
    │   │           └───reservationsservice
    │   │               │   ReservationsServiceApplication.java
    │   │               │
    │   │               ├───Dtos
    │   │               │       PersonDto.java
    │   │               │       ReservationDto.java
    │   │               │
    │   │               ├───entities
    │   │               │       Person.java
    │   │               │       Reservation.java
    │   │               │
    │   │               ├───feign
    │   │               │       ResourceFeignClient.java
    │   │               │
    │   │               ├───mappers
    │   │               │       ReservationMapper.java
    │   │               │
    │   │               ├───model
    │   │               │       Resource.java
    │   │               │
    │   │               ├───repositories
    │   │               │       PersonRepository.java
    │   │               │       ReservationRepository.java
    │   │               │
    │   │               ├───security
    │   │               │       FeignAdapter.java
    │   │               │       SecurityConfig.java
    │   │               │
    │   │               └───web
    │   │                       PersonController.java
    │   │                       ReservationController.java
    │   │
    │   └───resources
    │           application.properties
    │
    └───test
        └───java
            └───com
                └───sdia
                    └───reservationsservice
                            ReservationsServiceApplicationTests.java
```
## Resources Service

```
C:.                                       
│   .gitignore                            
│   Dockerfile                            
│   mvnw                                  
│   mvnw.cmd                              
│   pom.xml                               
│                                         
├───.mvn                                  
│   └───wrapper                           
│           maven-wrapper.jar             
│           maven-wrapper.properties      
│                                         
└───src                 
    ├───main            
    │   ├───java        
    │   │   └───com     
    │   │       └───sdia
    │   │           └───resourcesservice
    │   │               │   ResourcesServiceApplication.java
    │   │               │
    │   │               ├───Dtos
    │   │               │       ResourceClient.java
    │   │               │
    │   │               ├───entity
    │   │               │       Resource.java
    │   │               │
    │   │               ├───enums
    │   │               │       ResourceType.java
    │   │               │
    │   │               ├───mappers
    │   │               │       ResourceMappers.java
    │   │               │
    │   │               ├───repository
    │   │               │       ResourceRepository.java
    │   │               │
    │   │               ├───security
    │   │               │       SecurityConfig.java
    │   │               │
    │   │               └───web
    │   │                       ResourceController.java
    │   │
    │   └───resources
    │           application.properties
    │
    └───test
        └───java
            └───com
                └───sdia
                    └───resourcesservice
                            ResourcesServiceApplicationTests.java

```

## Front App

![login](https://github.com/Dembelinho/Reservations_Resources_Management/assets/110602716/399675a0-7072-40be-87d4-be94e6a658c7)

![resources front](https://github.com/Dembelinho/Reservations_Resources_Management/assets/110602716/5335f8f3-e818-4a2e-8187-b5d72e067f9a)

![rservations front](https://github.com/Dembelinho/Reservations_Resources_Management/assets/110602716/36abbd1b-9565-41dd-92df-8ca98ebd212d)

![resource of reserv](https://github.com/Dembelinho/Reservations_Resources_Management/assets/110602716/7cf9b4f9-2ff9-40ec-8504-0202688563ed)

![person who resrve](https://github.com/Dembelinho/Reservations_Resources_Management/assets/110602716/770a4d9f-463d-42e7-b99d-9c4359df5104)

![persons front](https://github.com/Dembelinho/Reservations_Resources_Management/assets/110602716/b6e5ed78-4f3f-4a32-80d1-17af3a047db0)

![persons front 2](https://github.com/Dembelinho/Reservations_Resources_Management/assets/110602716/c455512d-940c-4e4a-90fe-45ec50545533)
