package com.mytectra.learning.bookourshow.tickets;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;

public class TicketVendorImpl implements TicketVendor {

	List<Ticket> tickets = new ArrayList<Ticket>();
	
	@Override
	public List<Ticket> getTickets(Movie movie, TicketType ticketType, int count) throws TicketingExecption {
		List<Ticket> returnTickets = new ArrayList<Ticket>(); 
		for(Ticket ticket : tickets) {
			 if(ticket.getTicketType() == ticketType && ticket.getMovie().equals(movie)) {
				 returnTickets.add(ticket);
				 if(returnTickets.size() == count) {
					 return returnTickets;
				 }
			 }
					 
		 }
		throw new TicketingExecption("Not Found");
	}

	@Override
	public void loadTickets(Movie movie, TicketType ticketType, double price, int count) throws TicketingExecption {
		for (int i = 0; i < count; i++) {
			Ticket ticket = new Ticket( i , movie, ticketType, price);
			tickets.add(ticket);
		}
		//return true; 
	}

}
