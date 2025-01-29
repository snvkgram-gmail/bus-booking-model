package com.borneo.handson.busbooking.model;

import java.io.Serializable;
import java.util.Objects;
//import java.util.logging.*;

/**
 * A Bus runs between two cities.
 * This can be configured from master data. This is available for customers to search and find.
 * 
 * 
 * @author ramgo
 *
 */
public class Bus implements Serializable{
	
	private static final long serialVersionUID = -9115871962218893905L;
	//private static Logger log = Logger.getLogger(Bus.class.getName());
	
	/** RTA number assigned to any physical Bus like "KA015212" **/
	private String busNumber;
	
	private City originCity;
	private City destinationCity;
	private int capacity;
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Bus() {
		//log.info("Initialized - No Args constructor! ");
	}
	
	public Bus(String busNumber, City originCity, City destinationCity, int capacity) {
		this.busNumber = busNumber;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.capacity = capacity;
		//log.info( "Initialized Bus: "+ this.toString());
	}
	
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	
	public City getOriginCity() {
		return originCity;
	}
	public void setOriginCity(City originCity) {
		this.originCity = originCity;
	}
	
	public City getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(City destinationCity) {
		this.destinationCity = destinationCity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(busNumber, destinationCity, originCity);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		return Objects.equals(busNumber, other.busNumber) && destinationCity == other.destinationCity
				&& originCity == other.originCity;
	}
	
	@Override
	public String toString() {
		return "Bus [" + getBusNumber() + ", " + getOriginCity()
				+ ", " + getDestinationCity()
				+ ", " + getCapacity() + ""
				// + ", hashCode()=" + hashCode() + ""
				+ "]";
	}
	
	
	
	

}
