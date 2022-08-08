package com.coforge.training.airline.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.airline.model.Flight;
import com.coforge.training.airline.model.Passenger;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
