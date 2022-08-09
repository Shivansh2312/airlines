package com.coforge.training.airline.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.Flight;
import com.coforge.training.airline.repository.FlightRepository;

@Service
@Transactional
public class UserFlightRestService {
	
	@Autowired
	private FlightRepository fRepo;
	
	public List<Flight> userGetFlight(String departureAirport, String destinationAirport, LocalDate departureDate){
		return fRepo.getFlightDetails(departureAirport, destinationAirport, departureDate);
	}
}
