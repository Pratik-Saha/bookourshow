package com.mytectra.learning.bookourshow.web.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.mytectra.learning.bookourshow.entity.TicketType;

public class TicketLoadRequest {
	
	@NotNull
	@Positive(message = "movie id can not be negative")
	private int movieId;
	
	@NotNull
	@Positive(message = "price of ticket can not be negative")
	private double price;
	
	@NotNull
	private TicketType ticketType;
	
	@NotNull
	@Positive(message = "number of ticket can not be negative")
	private int count;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
	
	public TicketLoadRequest(@NotNull @Positive(message = "movie id can not be negative") int movieId,
			@NotNull @Positive(message = "price of ticket can not be negative") double price,
			@NotNull TicketType ticketType,
			@NotNull @Positive(message = "number of ticket can not be negative") int count) {
		super();
		this.movieId = movieId;
		this.price = price;
		this.ticketType = ticketType;
		this.count = count;
	}
	
	

}
