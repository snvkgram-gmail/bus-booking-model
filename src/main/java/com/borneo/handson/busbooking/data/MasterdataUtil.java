package com.borneo.handson.busbooking.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.borneo.handson.busbooking.model.Bus;
import com.borneo.handson.busbooking.model.City;

public class MasterdataUtil {
	
	//private static Logger log = Logger.getLogger(MasterdataUtil.class.getName());
	// storage of all buses
	static List<Bus> busesAll;
	
	// caching by bus number
	static Map<String, Bus> busesByBusNumber = new HashMap<>();
	/**
	 *  Create master data for buses.
	 *  Any other configuration required for Transport to start operations?? - not implemented as of now.
	 * @return List<Bus>
	 *  
	 */
	void setup() {
		List<Bus> buses = new ArrayList<>();
		int numberOfBuses = 4;
		
		/** Buses starting from BANGALORE to other cities **/
		for( int i=1; i<=numberOfBuses; i++ ) {
			String busNumber = "KA01 263"+i;
			Bus bus = new Bus(busNumber, City.BANGALORE, City.HYDERABAD, 2);
				buses.add( bus );
				busesByBusNumber.put(busNumber, bus);
		}
		
		for( int i=1; i<=numberOfBuses; i++ ) {
			String busNumber = "KA01 362"+i;
			Bus bus = new Bus(busNumber, City.BANGALORE, City.MADRAS, 25);
				buses.add( bus );
				busesByBusNumber.put(busNumber, bus);
		}
		
		/** Buses starting from HYDERABAD to other cities **/
		for( int i=1; i<=numberOfBuses; i++ ) {
			String busNumber = "TS08 894"+i;
			Bus bus = new Bus(busNumber, City.HYDERABAD, City.BANGALORE, 20);
				buses.add( bus );
				busesByBusNumber.put(busNumber, bus);
		}
		
		for( int i=1; i<=numberOfBuses; i++ ) {
			String busNumber = "TS08 498"+i;
			Bus bus = new Bus(busNumber, City.HYDERABAD, City.MADRAS, 18);
				buses.add( bus );
				busesByBusNumber.put(busNumber, bus);
		}
		
		/** Buses starting from MADRAS to other cities **/
		for( int i=1; i<=numberOfBuses; i++ ) {
			String busNumber = "TN03 580"+i;
			Bus bus = new Bus(busNumber, City.MADRAS, City.BANGALORE, 25);
				buses.add( bus );
				busesByBusNumber.put(busNumber, bus);
		}
		
		for( int i=1; i<=numberOfBuses; i++ ) {
			String busNumber = "TN03 085"+i;
			Bus bus = new Bus(busNumber, City.MADRAS, City.HYDERABAD, 18);
				buses.add( bus );
				busesByBusNumber.put(busNumber, bus);
		}
		
		int i = 1;
		for (Bus bus : buses) {
			System.out.println( bus.toString() );
			if( i%4 == 0 )
				System.out.println("");
			i++;
		}
		busesAll = buses;
		//return buses;
	}

}
