package com.sdia.reservationsservice.web;

import com.sdia.reservationsservice.Dtos.ReservationDto;
import com.sdia.reservationsservice.entities.Person;
import com.sdia.reservationsservice.entities.Reservation;
import com.sdia.reservationsservice.feign.ResourceFeignClient;
import com.sdia.reservationsservice.mappers.ReservationMapper;
import com.sdia.reservationsservice.model.Resource;
import com.sdia.reservationsservice.repositories.PersonRepository;
import com.sdia.reservationsservice.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController @AllArgsConstructor //@CrossOrigin("*")
public class ReservationController {
    private ReservationRepository reservationRepository;
    private PersonRepository personRepository;
    private ReservationMapper reservationMapper;
    private ResourceFeignClient resourceFeignClient;


//    List<Reservation> getReservationsByPersonId(Long personId){
//        List<Reservation> reservationList = reservationRepository.findAll();
//        List<Reservation> result = new ArrayList<>();
//        reservationList.forEach(reservation -> {
//            if (reservation.getPerson().getId() == personId)
//                result.add(reservation);
//        });
//        return result;
//    }
    @GetMapping(path = "/reservations")
    public List<Reservation> getAllReservations(){
        List<Reservation> reservationList = reservationRepository.findAll();
        reservationList.forEach(reservation -> {
            reservation.setResource(resourceFeignClient.getResourceById(reservation.getResourceId()));
        });
        return reservationList;
    }

    @GetMapping(path = "/reservations/{id}")
    public Reservation getReservationById(@PathVariable Long id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        Long resourceId = reservation.getResourceId();
        Resource resource = resourceFeignClient.getResourceById(resourceId);
        reservation.setResource(resource);
        return reservation;
    }

    @PostMapping("/reservations/add")
    public Reservation addReservation(@RequestBody ReservationDto reservation){
        Reservation reservation1 = reservationMapper.ReservationDtoToReservation(reservation);
        Long idPerson = reservation.getIdPerson();
        Person person = personRepository.findById(idPerson).orElseThrow();
        reservation1.setPerson(person);

        return reservationRepository.save(reservation1);
    }

    @DeleteMapping("/reservations/delete/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationRepository.deleteById(id);
    }

    @PutMapping("/reservations/update")
    public Reservation updateReservation(@RequestBody ReservationDto reservation){
        Reservation reservation1 = reservationMapper.ReservationDtoToReservation(reservation);
        Long idPerson = reservation.getIdPerson();
        Person person = personRepository.findById(idPerson).orElseThrow();
        reservation1.setPerson(person);
        return reservationRepository.save(reservation1);
    }
}
