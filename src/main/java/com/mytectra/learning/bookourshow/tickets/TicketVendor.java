package com.mytectra.learning.bookourshow.tickets;

import java.util.List;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;

public interface TicketVendor {
	
	List<Ticket> getTickets(Movie movie, TicketType ticketType , int count ) throws TicketingException;

	void loadTickets(Movie movie, TicketType ticketType ,double price ,  int count ) throws TicketingException;
}
