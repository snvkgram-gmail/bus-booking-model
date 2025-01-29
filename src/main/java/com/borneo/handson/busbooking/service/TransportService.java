package com.borneo.handson.busbooking.service;

import java.util.List;

import com.borneo.handson.busbooking.model.Bus;
import com.borneo.handson.busbooking.model.City;

public interface TransportService {
	
	/** Returns all Buses **/
	List<Bus> getBuses();
	
	/** Returns Buses originating from a specific origin City **/
	List<Bus> getBuses(City origin);
	
	Bus getBus(String busNumber);
	
	// next version
	/** Returns Buses originating from a specific origin City, on a given date **/
	/** This is a configuration/setup for each bus by date **/
	/** While making a booking, we should see if the bus is running on this route and date **/
	//List<Bus> getBuses(LocalDate date, City origin);

 
}
