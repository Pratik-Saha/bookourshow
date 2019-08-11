package com.mytectra.learning.bookourshow.web.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;

public class BookingRequest {
	
	@NotNull
	@Positive(message = "Movie id cannot be negative")
	private int movieId;
	
	@NotNull
	private TicketType ticketType;
	
	@NotNull
	@Positive(message = "number of tickets cannot be negative")
	private int count;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
