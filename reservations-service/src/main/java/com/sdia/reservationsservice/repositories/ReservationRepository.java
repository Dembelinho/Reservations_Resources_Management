package com.sdia.reservationsservice.repositories;

import com.sdia.reservationsservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> getReservationsByPersonId(Long personId);
}
