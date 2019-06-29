package com.mytectra.learning.bookourshow.entity;

import java.util.List;

public class Booking {
	
	private int id;
	
	//private User user;
	
	private List<Ticket> tickets;
	
	private double price;
	
	private List<String> offersApplied;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getOffersApplied() {
		return offersApplied;
	}

	public void setOffersApplied(List<String> offersApplied) {
		this.offersApplied = offersApplied;
	}

}
