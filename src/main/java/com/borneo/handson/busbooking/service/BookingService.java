package com.borneo.handson.busbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.borneo.handson.busbooking.model.Booking;
import com.borneo.handson.busbooking.model.Bus;

public interface BookingService {

	/** Makes a booking on a Bus, on a given date 
	 * @throws Exception **/
	Booking book(Bus bus, LocalDate date) throws Exception;
	
	/** Get bookings of a bus on a given date **/
	List<Booking> getBookings(Bus bus, LocalDate date);
	
	/** Returns booking details by booking Id **/
	Booking get(long bookingId);
	
	/** Cancels a Booking by booking id **/
	Booking cancel(long bookingId);
	
	
	
}
