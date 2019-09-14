package com.mytectra.learning.bookourshow.tickets;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.TicketType;

//@Component
public class TicketVendorImpl implements TicketVendor {

	public List<Ticket> tickets = new ArrayList<Ticket>();
	
	@Override
	public List<Ticket> getTickets(Movie movie, TicketType ticketType, int count) throws TicketingException {
		List<Ticket> returnTickets = new ArrayList<Ticket>(); 
		for(Ticket ticket : tickets) {
			 if(ticket.getTicketType() == ticketType && ticket.getMovie().equals(movie)) {
				 returnTickets.add(ticket);
				 if(returnTickets.size() == count) {
					 return returnTickets;
				 }
			 }
					 
		 }
		throw new TicketingException("Not Found");
	}

	@Override
	public  void loadTickets(Movie movie, TicketType ticketType, double price, int count) throws TicketingException {
		for (int i = 0; i < count; i++) {
			Ticket ticket = new Ticket( i , movie, ticketType, price);
			
			tickets.add(ticket);
		}
	}

}
