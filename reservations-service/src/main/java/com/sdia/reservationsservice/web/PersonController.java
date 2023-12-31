package com.sdia.reservationsservice.web;

import com.sdia.reservationsservice.Dtos.PersonDto;
import com.sdia.reservationsservice.entities.Person;
import com.sdia.reservationsservice.mappers.ReservationMapper;
import com.sdia.reservationsservice.repositories.PersonRepository;
import com.sdia.reservationsservice.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor //@CrossOrigin("*")
public class PersonController {

    private PersonRepository personRepository; //private ReservationRepository reservationRepository;
    ReservationMapper reservationMapper;

    @GetMapping(path = "/persons")
    public List<Person> getAllPersons(){
        List<Person> personList = personRepository.findAll();
//        personList.forEach(person -> {
//            person.setReservations(reservationRepository.getReservationsByPersonId(person.getId()));
//        });
        return personList;
    }

    @GetMapping(path = "/persons/{id}")
    public Person getPersonById(@PathVariable(name = "id") Long id){
        Person person = personRepository.findById(id).get();
        //person.setReservations(reservationRepository.getReservationsByPersonId(id));
        return person;
       // return personRepository.findById(id).orElseThrow();
    }

    @PostMapping("/persons/add")
    public Person addPerson(@RequestBody PersonDto person) {
        Person person1 = reservationMapper.PersonDtoToPerson(person);
        return personRepository.save(person1);
    }

    @DeleteMapping("/persons/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @PutMapping("/persons/update")
    public Person updatePerson(@RequestBody PersonDto person) {
        Person person1 = reservationMapper.PersonDtoToPerson(person);
        return personRepository.save(person1);
    }

}
