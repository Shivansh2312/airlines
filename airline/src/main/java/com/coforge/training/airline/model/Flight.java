package com.coforge.training.airline.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
	
@Entity
@Table(name="flight")
public class Flight {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private long flightId;
	    
	    private String flightNumber;
	   
	    private  String departureAirport;
	   
	    private String destinationAirport;

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate departureDate;

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate arrivalDate;

	    private String departureTime;

	    private String arrivalTime;
	    
	    private double cabin;

	    private double flightCharge;

		public Flight() {
			super();
		}
		
		

		public Flight(long flightId, String flightNumber, String departureAirport, String destinationAirport,
				LocalDate departureDate, LocalDate arrivalDate, String departureTime, String arrivalTime, double cabin,
				double flightCharge) {
			super();
			this.flightId = flightId;
			this.flightNumber = flightNumber;
			this.departureAirport = departureAirport;
			this.destinationAirport = destinationAirport;
			this.departureDate = departureDate;
			this.arrivalDate = arrivalDate;
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
			this.cabin = cabin;
			this.flightCharge = flightCharge;
		}



		public long getFlightId() {
			return flightId;
		}

		public void setFlightId(long flightId) {
			this.flightId = flightId;
		}

		public String getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}

		public String getDepartureAirport() {
			return departureAirport;
		}

		public void setDepartureAirport(String departureAirport) {
			this.departureAirport = departureAirport;
		}

		public String getDestinationAirport() {
			return destinationAirport;
		}

		public void setDestinationAirport(String destinationAirport) {
			this.destinationAirport = destinationAirport;
		}

		public LocalDate getDepartureDate() {
			return departureDate;
		}

		public void setDepartureDate(LocalDate departureDate) {
			this.departureDate = departureDate;
		}

		public LocalDate getArrivalDate() {
			return arrivalDate;
		}

		public void setArrivalDate(LocalDate arrivalDate) {
			this.arrivalDate = arrivalDate;
		}

		public String getDepartureTime() {
			return departureTime;
		}

		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime;
		}

		public String getArrivalTime() {
			return arrivalTime;
		}

		public void setArrivalTime(String arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		
		public double getCabin() {
			return cabin;
		}

		public void setCabin(double cabin) {
			this.cabin = cabin;
		}



		public double getFlightCharge() {
			return flightCharge;
		}

		public void setFlightCharge(double flightCharge) {
			this.flightCharge = flightCharge;
		}



		@Override
		public String toString() {
			return "Flight [flightId=" + flightId + ", flightNumber=" + flightNumber + ", departureAirport="
					+ departureAirport + ", destinationAirport=" + destinationAirport + ", departureDate="
					+ departureDate + ", arrivalDate=" + arrivalDate + ", departureTime=" + departureTime
					+ ", arrivalTime=" + arrivalTime + ", cabin=" + cabin + ", flightCharge=" + flightCharge + "]";
		}
}
