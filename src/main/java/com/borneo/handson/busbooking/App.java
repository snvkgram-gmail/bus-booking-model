package com.borneo.handson.busbooking;

import java.time.LocalDate;
import java.util.List;

import com.borneo.handson.busbooking.data.DataStorage;
import com.borneo.handson.busbooking.model.Booking;
import com.borneo.handson.busbooking.model.Bus;
import com.borneo.handson.busbooking.model.City;
import com.borneo.handson.busbooking.service.BookingService;
import com.borneo.handson.busbooking.service.BookingServiceImpl;
import com.borneo.handson.busbooking.service.TransportService;
import com.borneo.handson.busbooking.service.TransportServiceImpl;

/**
 * An application to book a bus between any given two cities.
 * Requirements:
 * 	A Transport company has buses to shuttle between any cities.
 * 	Each Bus shuttles between two cities.
 * 
 * 	A customer should be able to search the available buses from the origin city.
 * 	A Customer can check the availability on a given day.
 * 	A Customer can make a booking by selecting a date and origin city (& destination city).
 * 
 * 	Rudra is curious to see how the data model will store the bus bookings with date.
 * 
 * 	Questions:
 * 	Do we need a Bus Service?
 * 	If so, Bus should be referred by a Transport Service provider.
 * 	So, we can make this out of scope for the sake of simplicity.
 * 
 * 
 * 	Iteration 2:
 * 	Add operational status to Bus.
 * 	Add a method to TransportService to return only Operational Buses.
 * 	Buses configured for each date (in a month). This will demand different way storing & retrieving buses.
 * 
 * @author ramgo
 *
 */
public class App {
	
	public static void main0(String[] args) {
		System.out.println(City.valueOf(City.BANGALORE.toString()));
	}
	
    public static void main(String[] args) {
    	System.out.println("----------------Setting up Data----------------");
    	DataStorage.setup();
    	System.out.println("----------------Completed Setting up Data----------------\n\n");
    	
    	TransportService transportService = new TransportServiceImpl();
    		List<Bus> allBuses = transportService.getBuses();
    	System.out.println("All Buses: "+ allBuses + "\n\n");
    	
    	List<Bus> busesOrigin = transportService.getBuses(City.BANGALORE);
    	System.out.println("Buses by origin: "+ busesOrigin.size() + ", " + busesOrigin + "\n\n");
    	
    	
    	BookingService bookingService = new BookingServiceImpl();
		
    	// 1
    	/** Use below block to make bookings **/
    	LocalDate myDate = LocalDate.of(2025, 1, 30);
    	Bus myBus1 = transportService.getBus("KA01 2631");
    	
    	try {
			System.out.println("This bus: "+ myBus1 + " has the capacity "+ myBus1.getCapacity() + " and trying to book by 4 times as below. You should see Bus is full message after 2 bookings");
			bookingService.book(myBus1, myDate);
			bookingService.book(myBus1, myDate);
			bookingService.book(myBus1, myDate);
			bookingService.book(myBus1, myDate);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
    	/** Booking block ends here **/
    	
    	// 2
    	/** Use below block to make bookings **/
    	LocalDate myDate2 = LocalDate.of(2025, 1, 30);
    	Bus myBus2 = transportService.getBus("TN03 5801");
    	
    	try {
			System.out.println("\n \n 2 - This bus: "+ myBus2 + " has the capacity "+ myBus2.getCapacity() + " and trying to book by so many times as below");
			bookingService.book(myBus2, myDate2);
			bookingService.book(myBus2, myDate2);
			bookingService.book(myBus2, myDate2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
    	/** Booking block ends here **/
		// Uncomment below code to get the bookings made
    	System.out.println("\n \n Printing bookings for both buses");
    	List<Booking> bookings1 = bookingService.getBookings(myBus1, myDate);
    	for (Booking booking : bookings1) 
			System.out.println(booking);
    	
    	List<Booking> bookings2 = bookingService.getBookings(myBus2, myDate);
    	for (Booking booking : bookings2) 
			System.out.println(booking);
    }
}
