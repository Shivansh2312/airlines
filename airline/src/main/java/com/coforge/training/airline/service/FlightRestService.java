package com.coforge.training.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.training.airline.model.Flight;
import com.coforge.training.airline.repository.FlightRepository;


@Service
@Transactional
public class FlightRestService {
	
	@Autowired
	private FlightRepository fRepo;

	
	   
	
	    public List<Flight> listAll() {
	        return fRepo.findAll();
	    }
	    
	    public Flight getFlightById(long flightId) {
	        return fRepo.findById(flightId).orElse(null);
	    }
	    
	    public Flight saveFlight(Flight flight) {
	        return fRepo.save(flight);
	    }
	    
		public Optional<Flight> getSingleFlight(long id) {
	        return fRepo.findById(id);  // defined in JPA repo
	    }
	    
	    public void deleteFlightById(long flightId) {
	        fRepo.deleteById(flightId);
	    }
        
	   
	    
//	    public List<Flight> getAllFlightsByAirportAndDepartureTime(String depAirport, String destAirport, LocalDate depDate) {
//	        return fRepo.findAllByDepartureAirportEqualsAndDestinationAirportEqualsAndDepartureDateEquals(depAirport, destAirport, depDate);
//	    }
//		

}
