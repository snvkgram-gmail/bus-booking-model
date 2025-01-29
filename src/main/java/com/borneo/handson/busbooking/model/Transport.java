package com.borneo.handson.busbooking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Transport implements Serializable{
	
	private static final long serialVersionUID = 4542541418063978677L;
	
	/** Name of the transport company **/
	private String name;
	
	/** Buses operated by this Transport Company **/
	private List<Bus> buses = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Bus> getBuses() {
		return buses;
	}
	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(buses, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transport other = (Transport) obj;
		return Objects.equals(buses, other.buses) && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "Transport [getName()=" + getName() + ", getBuses()=" + getBuses() + ", hashCode()=" + hashCode() + "]";
	}

	
}
