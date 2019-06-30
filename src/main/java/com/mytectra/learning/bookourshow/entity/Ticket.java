package com.mytectra.learning.bookourshow.entity;

import java.util.Date;

public class Ticket {
	
	private long id;
	
	private Movie movie;
	
	public enum TicketType {
		GOLD,
		SILVER,
		PLATINUM
	}
	
	private TicketType ticketType;
	
	private double price;
	
	private boolean discounted;
	
	public Ticket(long id ,Movie movie, TicketType ticketType, double price) {
		this.id = id;
		this.movie = movie;
		this.ticketType = ticketType;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDiscounted() {
		return discounted;
	}

	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}
	
	
	
	
	
}
