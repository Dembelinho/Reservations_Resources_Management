package com.sdia.reservationsservice.mappers;

import com.sdia.reservationsservice.Dtos.PersonDto;
import com.sdia.reservationsservice.Dtos.ReservationDto;
import com.sdia.reservationsservice.entities.Person;
import com.sdia.reservationsservice.entities.Reservation;
import com.sdia.reservationsservice.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Component
public class ReservationMapper {
    PersonRepository personRepository;
    public Reservation ReservationDtoToReservation(ReservationDto reservationDto){
        Person person = personRepository.findById(reservationDto.getIdPerson())
                .orElseThrow(() -> new RuntimeException("Person not found"));
        return Reservation.builder()
                .name(reservationDto.getName())
                .context(reservationDto.getContext())
                .date(LocalDate.now())
                .Duration(reservationDto.getDuration())
                .person(person)
                .resourceId(reservationDto.getResourceId())
                .build();
    }

    public ReservationDto ReservationToReservationDto(Reservation reservation){
        return ReservationDto.builder()
                .name(reservation.getName())
                .context(reservation.getContext())
                .Duration(reservation.getDuration())
                .idPerson(reservation.getPerson().getId())
                .resourceId(reservation.getResourceId())
                .build();
    }

    public Person PersonDtoToPerson(PersonDto personDto){
        return Person.builder()
                .name(personDto.getName())
                .email(personDto.getEmail())
                .function(personDto.getFunction())
                .build();
    }
    public PersonDto PersonToPersonDto(Person person){
        return PersonDto.builder()
                .name(person.getName())
                .email(person.getEmail())
                .function(person.getFunction())
                .build();
    }
}
