package com.coforge.training.airline.restController;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.coforge.training.airline.service.AdminFlightRestService;



@RestController
@RequestMapping(value= "api/admin_login")
@CrossOrigin(origins="http://localhost:3000")
public class AdminFlightRestController {

	@Autowired
	private AdminFlightRestService afservice;

	//Open PostMan , make a GET request- http://localhost:8085/airline/api/all_flights
	@GetMapping("/all_flights")
	public List<Flight>getAllFlights () {
		return afservice.listAll();  
	}
	
	@GetMapping("/all_flights/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable(value = "id") Long flightId)
       throws ResourceNotFoundException {
		Flight flight = afservice.getSingleFlight(flightId)
           .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + flightId));
   return ResponseEntity.ok().body(flight);
}

	//Open PostMan , make a Post request- http://localhost:8085/airline/api/all_flights
	@PostMapping("/add_flight")
	public ResponseEntity<Flight> saveFlight(@Validated @RequestBody Flight flight) {

		Flight p= afservice.saveFlight(flight)  ;
		return ResponseEntity.ok(p);
	}
	
	//Open PostMan , make a PUT request- http://localhost:8085/airline/api//update_flight/{id}
	@PutMapping("/update_flight/{id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable(value = "id") Long pId,
			@Validated @RequestBody Flight f) throws ResourceNotFoundException {

		Flight flight = afservice.getSingleFlight(pId)
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
		final Flight updatedFlight = afservice.saveFlight(flight);
		return ResponseEntity.ok(updatedFlight);
	}

	//Open PostMan , make a delete request- http://localhost:8085/airline/api/admin_login/delete_flight/2
	//Select body -> select raw -> JSON 
	//Delete the JSON Product object

	@DeleteMapping("/delete_flight/{flightId}")
	public Map<String, Boolean> deleteFlight(@PathVariable(value = "flightId") Long pId)
			throws ResourceNotFoundException{

		afservice.deleteFlightById(pId);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}