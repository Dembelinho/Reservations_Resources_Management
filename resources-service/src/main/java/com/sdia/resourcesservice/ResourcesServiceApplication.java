package com.sdia.resourcesservice;

import com.sdia.resourcesservice.entity.Resource;
import com.sdia.resourcesservice.enums.ResourceType;
import com.sdia.resourcesservice.repository.ResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResourcesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourcesServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ResourceRepository resourceRepository){
		return args -> {
			List.of("LAPTOP","Printer","Scanner").forEach(
					res->{
						Resource resource = Resource
								.builder()
								.name(res)
								.type(Math.random()>0.5? ResourceType.MATERIEL_INFO:ResourceType.MATERIEL_AUDIO_VUSUEL)
								.build();
						resourceRepository.save(resource);

					}
			);

			resourceRepository.findAll().forEach(System.out::println);
			//System.out.println(resourceRepository.findByName("LAPTOP"));
		};
	}

}
