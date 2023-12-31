package com.sdia.reservationsservice.repositories;

import com.sdia.reservationsservice.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
