package com.coforge.training.airline.model;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

@Entity
@Table(name="booking")
public class Booking {
	 
	@Id
    private Long bookingId;
    private Date bookingDate;  // Current date of the user
    private String email;
    
    @ElementCollection(targetClass=String.class)
    private List<String> seatId = new ArrayList<>();
    
    @ElementCollection(targetClass=String.class)
    private List<String> passengerName = new ArrayList<>();
    
	private String passengerAge;
    
    private String passportNumber;
    private int numberOfSeats;
    private int price;
    public boolean bookingStatus = false;
	private  int totalAmount;
    
    public Booking() {}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getSeatId() {
		return seatId;
	}

	public void setSeatId(List<String> seatId) {
		this.seatId = seatId;
	}

	public List<String> getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(List<String> passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
    
    
}
//	@ElementCollection
//	@Convert(PassengerObjectClass.class)
//    private Map<String, Integer> passengerName = new HashMap<String,Integer>();

//    public Map<String, Integer> getPassengerName() {
//		return passengerName;
//	}
//
//	public void setPassengerName(Map<String, Integer> passengerName) {
//		this.passengerName = passengerName;
//	}