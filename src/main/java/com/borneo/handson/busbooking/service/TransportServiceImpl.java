package com.borneo.handson.busbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.borneo.handson.busbooking.data.DataStorage;
import com.borneo.handson.busbooking.model.Bus;
import com.borneo.handson.busbooking.model.City;

/**
 * This is mainly used to return available Buses and their details.
 * Mainly for search and find.
 * 
 * For actual booking, use BookingService.
 * 
 * @author ramgo
 *
 */
public class TransportServiceImpl implements TransportService{

	private DataStorage storage = new DataStorage();
	
	@Override
	public List<Bus> getBuses() {
		return storage.getBuses();
	}

	@Override
	public List<Bus> getBuses(City origin) {
		return storage.getBuses(City.valueOf(origin.toString()));
	}

	@Override
	public Bus getBus(String busNumber) {
		return storage.getBus(busNumber);
	}

	//@Override
	/* public List<Bus> getBuses(LocalDate date, City origin) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	

}
