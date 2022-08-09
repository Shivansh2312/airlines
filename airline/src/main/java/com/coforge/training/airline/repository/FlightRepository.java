package com.coforge.training.airline.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coforge.training.airline.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("SELECT f from flight f where f.departureAirport=?1 and f.destinationAirport=?2 and f.departureDate=?3")
	public List<Flight> getFlightDetails(String departureAirport, String destinationAirport, LocalDate departureDate);
}

