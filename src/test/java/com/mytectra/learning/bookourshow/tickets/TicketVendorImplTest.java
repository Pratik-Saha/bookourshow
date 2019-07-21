package com.mytectra.learning.bookourshow.tickets;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;

public class TicketVendorImplTest {
	
	private List<Ticket> tickets;
	private TicketVendorImpl ticketVendorImpl;
	
	TicketType ticketType;
	double price;
	
	@Before
	public void setUp()
	{
		tickets = new ArrayList<Ticket>();
		ticketVendorImpl = new TicketVendorImpl();
		

	
	}
	
	@Test
	public void testtickets1() throws TicketingExecption {
		Movie movie= new Movie();
		movie.setId(1);
		movie.setMovieName("Rambo");
		movie.setInfo("Hindi");
		
		ticketVendorImpl.loadTickets(movie, ticketType.GOLD, 200, 10);
		tickets =   ticketVendorImpl.getTickets(movie, ticketType.GOLD, 10);
		
				
	}
	
	
	
}
