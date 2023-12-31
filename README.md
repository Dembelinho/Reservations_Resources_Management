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





