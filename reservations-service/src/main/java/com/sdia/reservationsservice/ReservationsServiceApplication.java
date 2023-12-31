package com.sdia.reservationsservice;

import com.sdia.reservationsservice.entities.Person;
import com.sdia.reservationsservice.entities.Reservation;
import com.sdia.reservationsservice.feign.ResourceFeignClient;
import com.sdia.reservationsservice.repositories.PersonRepository;
import com.sdia.reservationsservice.repositories.ReservationRepository;
import com.sdia.reservationsservice.web.PersonController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class ReservationsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationsServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ReservationRepository reservationRepository,
										PersonRepository personRepository){
		return args -> {
			List.of("Khalil","Mohamed","Ahmed","Ali","Hassan")
					.forEach(name -> personRepository.save(new Person(null,name,
							name+"@gmail.com",Math.random()>0.5?"CHEF":"Employee",null)));
			for (int i = 1; i < 5; i++){
				reservationRepository.save(new Reservation(null,"Reservation"+i,
						Math.random()>0.5?"ACCEPTED":"REJECTED",LocalDate.now(),(long) 15+i,
						null,new Random().nextLong(1,3),personRepository.findById((long) i).get()));
			}
		};
	}

}
