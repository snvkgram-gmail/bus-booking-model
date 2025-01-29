package com.borneo.handson.busbooking.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.LongAdder;

/**
 * A booking is done by a customer to travel from one City to another City, for a given date.
 * 
 * @author ramgo
 *
 */
public class Booking implements Serializable{

	private static final long serialVersionUID = -5920198950586703812L;
	private static LongAdder counter = new LongAdder();
	
	private long bookingId;
	private LocalDate date;
	private Bus bus;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	
	public Booking(LocalDate date, Bus bus) {
		counter.increment();
		this.bookingId = counter.longValue();
		this.date = date;
		this.bus = bus;
	}
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, bus, date);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return bookingId == other.bookingId && Objects.equals(bus, other.bus) && Objects.equals(date, other.date);
	}
	
	@Override
	public String toString() {
		return "Booking [getBookingId()=" + getBookingId() + ", getBus()=" + getBus() + ", getDate()=" + getDate()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
}
