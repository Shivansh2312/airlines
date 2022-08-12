package com.coforge.training.airline.restController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.airline.model.Booking;
import com.coforge.training.airline.model.Flight;
import com.coforge.training.airline.repository.BookingRepository;
import com.coforge.training.airline.service.UserFlightRestService;

@RestController
@RequestMapping(value="api/user")
public class UserFlightRestController {
	
	@Autowired
	private UserFlightRestService ufservice;
	@Autowired
	private BookingRepository brepo;
	
//	Open Postman and Give GET request :- 
//	http://localhost:8085/airline/api/user/search_flight/Chennai/Banglore/2022-09-21
	
	@GetMapping("/search_flight/{departureAirport}/{destinationAirport}/{departureDate}")
	public ResponseEntity<List<Flight>> getAvailableFlights(@PathVariable String departureAirport, @PathVariable String destinationAirport, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate)
	{
		return new ResponseEntity<>(ufservice.userGetFlight(departureAirport, destinationAirport, departureDate), HttpStatus.OK);
	}
	
    //POST - http://localhost:9090/aerocom/api/booking
    @PostMapping("/booking")
    public String saveFlight(@RequestBody Booking booking) throws Exception
    {
        List<String> arr = booking.getSeatId();
        List<Booking> b = brepo.findBySeatIdIn(arr);
        if (b.isEmpty()) {
            booking.setNumberOfSeats(booking.getNumberOfSeats());
            booking.setTotalAmount(booking.getTotalAmount());
            brepo.save(booking);
            return "";
        }else
            throw new Exception("Seat is already booked"+b);
    }
	
	
	
}
