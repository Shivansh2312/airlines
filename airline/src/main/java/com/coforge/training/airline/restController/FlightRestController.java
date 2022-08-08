package com.coforge.training.airline.restController;

import java.time.LocalDate;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.airline.exception.ResourceNotFoundException;
import com.coforge.training.airline.model.Flight;
import com.coforge.training.airline.model.Passenger;
import com.coforge.training.airline.service.FlightRestService;


@RestController
@RequestMapping(value= "api/admin_login")
public class FlightRestController {

	@Autowired
	private FlightRestService fservice;
	private String departureAirport;

	//Open PostMan , make a GET request- http://localhost:8085/airline/api/flights
	@GetMapping("/all_flights")
	public List<Flight>getAllFlights () {
		return fservice.listAll();  
	}


	//Open PostMan , make a Post request- http://localhost:8085/airline/api/flights/
	@PostMapping("/add_flight")
	public ResponseEntity<Flight> saveFlight(@Validated @RequestBody Flight flight) {

		Flight p= fservice.saveFlight(flight)  ;
		return ResponseEntity.ok(p);

	}

	@PutMapping("/update_flight/{id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable(value = "id") Long pId,
			@Validated @RequestBody Flight f) throws ResourceNotFoundException {

		Flight flight = fservice.getSingleFlight(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));


		flight.setFlightNumber(f.getFlightNumber());
		flight.setDepartureAirport(f.getDepartureAirport());
		flight.setDestinationAirport(f.getDestinationAirport());
		flight.setDepartureDate(f.getDepartureDate());
		flight.setArrivalDate(f.getArrivalDate());
		flight.setDepartureTime(f.getDepartureTime());
		flight.setArrivalTime(f.getArrivalTime());
		flight.setCabin(f.getCabin());
		flight.setFlightCharge(f.getFlightCharge());
		final Flight updatedFlight = fservice.saveFlight(flight);
		return ResponseEntity.ok(updatedFlight);
	}

	//Open PostMan , make a delete request- http://localhost:8085/airline/api/admin_login/delete_flight/2
	//Select body -> select raw -> JSON 
	//Delete the JSON Product object

	@DeleteMapping("/delete_flight/{flightId}")
	public Map<String, Boolean> deleteFlight(@PathVariable(value = "flightId") Long pId)
			throws ResourceNotFoundException{

		fservice.deleteFlightById(pId);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}