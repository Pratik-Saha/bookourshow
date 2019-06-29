package com.mytectra.learning.bookourshow.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.pricing.Pricing;
import com.mytectra.learning.bookourshow.tickets.TicketVendor;
import com.mytectra.learning.bookourshow.tickets.TicketingExecption;

@Component
public class BookOurShow {
	
	@Autowired
	private TicketVendor ticketVendor;
	
	@Autowired
	private Pricing pricing;
	
	
	public Booking bookTickets(Movie movie , TicketType ticketType ,  int numberOfTickets) throws TicketingExecption {
		 List<Ticket> tickets = ticketVendor.getTickets(movie, ticketType, numberOfTickets);
		 Booking booking = new Booking();
		 booking.setId(76885);
		 booking.setTickets(tickets);
		 pricing.price(booking);
		 return booking;
		
	}

}
