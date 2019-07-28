package com.mytectra.learning.bookourshow.core;

import java.util.Date;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.offer.Offer;
import com.mytectra.learning.bookourshow.pricing.Pricing;
import com.mytectra.learning.bookourshow.tickets.TicketVendor;
import com.mytectra.learning.bookourshow.tickets.TicketingExecption;

public class BookOurShow {
	
	
	private TicketVendor ticketVendor;
	
	
	private Pricing pricing;
	
	
	private Offer offer;
	
	
	public BookOurShow(TicketVendor ticketVendor, Pricing pricing, Offer offer) {
		super();
		this.ticketVendor = ticketVendor;
		this.pricing = pricing;
		this.offer = offer;
	}

	public Booking bookTickets(Movie movie , TicketType ticketType ,  int numberOfTickets) throws TicketingExecption {
		 List<Ticket> tickets = ticketVendor.getTickets(movie, ticketType, numberOfTickets);
		 Booking booking = new Booking();
		 booking.setId((int) new Date().getTime());
		 booking.setTickets(tickets);
		 offer.applyOffer(booking);
		 pricing.price(booking);
		 return booking;
	}

}
