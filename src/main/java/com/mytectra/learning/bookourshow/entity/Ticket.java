package com.mytectra.learning.bookourshow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name = "load_tickets" , query = "select t from Ticket t where t.movie = ?1 and t.ticketType = ?2 and t.booking is null")
public class Ticket {
	@Id
	@Column(name = "ticketId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movie movie;
	
	@Column(name = "ticketType")
	@Enumerated(EnumType.STRING)
	private TicketType ticketType;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "discounted")
	private boolean discounted;
	
	@ManyToOne
	@JoinColumn(name = "booking_id" ,nullable = true)
	@JsonIgnore
	private Booking booking;
	
	
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Ticket() {
	}	

	public Ticket(long id ,Movie movie, TicketType ticketType, double price) {
		this.id = id;
		this.movie = movie;
		this.ticketType = ticketType;
		this.price = price;
	}
	
	public Ticket(Movie movie, TicketType ticketType, double price) {
		this.movie = movie;
		this.ticketType = ticketType;
		this.price = price;
		//this.count = count;
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
