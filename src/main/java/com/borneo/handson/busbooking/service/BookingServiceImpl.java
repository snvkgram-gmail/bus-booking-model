package com.borneo.handson.busbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.borneo.handson.busbooking.data.DataStorage;
import com.borneo.handson.busbooking.model.Booking;
import com.borneo.handson.busbooking.model.Bus;

public class BookingServiceImpl implements BookingService{

	private DataStorage storage = new DataStorage();
	
	@Override
	public Booking book(Bus bus, LocalDate date) throws Exception {
		return storage.book( bus, date);
	}

	@Override
	public Booking get(long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking cancel(long bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookings(Bus bus, LocalDate date) {
		return storage.getBookings( bus, date);
	}
	
	
	

}
