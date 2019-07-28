package com.mytectra.learning.bookourshow.web.entity;

import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;

public class BookingRequest {
	
	private int movieId;
	
	private TicketType ticketType;
	
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
