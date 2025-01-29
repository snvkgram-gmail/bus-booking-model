package com.borneo.handson.busbooking.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.borneo.handson.busbooking.model.Booking;
import com.borneo.handson.busbooking.model.Bus;
import com.borneo.handson.busbooking.model.City;

/**
 * This is used an in-memory Data storage.
 * This class uses efficient way of storing & retrieving objects in a convenient way.
 * For company 
 * 
 * @author ramgo
 *
 */
public class DataStorage {
	private static List<Bus> buses;
	private static Map<String, Bus> busesByBusNumber;
	
	public static void setup() {
		new MasterdataUtil().setup();
		buses = MasterdataUtil.busesAll;
		busesByBusNumber = MasterdataUtil.busesByBusNumber;
		
		System.out.println( "buses size: "+ buses.size() );
	}
	
	// bookings map to get by date and bus
	Map<String, List<Booking>> bookingsMap = new HashMap<>();
	

	public List<Bus> getBuses() {
		return buses;
	}

	public List<Bus> getBuses(City city) {
		//System.out.println("in DataStorage.getBuses by City: "+ city.toString());
		List<Bus> busesByCity = new ArrayList<>();
		for (Bus bus : buses) {
			if( bus.getOriginCity().equals(city) )
				busesByCity.add(bus);
		}
		return busesByCity;
	}

	public Bus getBus(String busNumber) {
		Bus bus = busesByBusNumber.get(busNumber);
		return bus;
	}

	public Booking book(Bus bus, LocalDate date) throws Exception {
		String key = createKey(bus, date);
		List<Booking> busBookingsOnADate = getBookingsListOnADate(key);
		
		Booking booking = null;
		if( busBookingsOnADate.size() < bus.getCapacity() ) {
			booking = new Booking(date, bus);
			createBooking(key, busBookingsOnADate, booking);
			System.out.println("Booking is successful! "+ booking);
		}else
			throw new Exception("Bus is full");
		
		return booking;
	}
	
	public List<Booking> getBookings(Bus bus, LocalDate date) {
		String key = createKey(bus, date);
		List<Booking> busBookingsOnADate = getBookingsListOnADate(key);
		return busBookingsOnADate;
	}
	
	

	private List<Booking> getBookingsListOnADate(String key) {
		List<Booking> busBookingsOnADate = bookingsMap.get(key);
			busBookingsOnADate = (null==busBookingsOnADate) ? new ArrayList<Booking>() : busBookingsOnADate;
		return busBookingsOnADate;
	}

	/**
	 * Creates a new Booking.
	 * Updates the bookings map with new list of bookings matching with the key
	 * 
	 * @param key
	 * @param busBookingsOnADate
	 * @param booking
	 */
	private void createBooking(String key, List<Booking> busBookingsOnADate, Booking booking) {
		busBookingsOnADate.add( booking );
		bookingsMap.put(key, busBookingsOnADate);
	}

	/**
	 * Creates a key with date,busNumber and city 
	 * 
	 * concatenate localdate,busnumber,Bus.City 
	 * 
	 * @param bus
	 * @param date
	 * @return
	 */
	private String createKey(Bus bus, LocalDate date) {
		StringBuilder key = new StringBuilder();
			key.append(date.toString() );
			key.append("__" );
			key.append(bus.getBusNumber() );
			key.append("__" );
			key.append(bus.getOriginCity().toString() );
		return key.toString();
	}

	
	
}
