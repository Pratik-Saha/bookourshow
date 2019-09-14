package com.mytectra.learning.bookourshow.tickets;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.TicketType;

public class TicketVendorImplTest {
	
	Movie movie;
	TicketVendorImpl ticketVendor;
	List<Ticket> returnTickets;
	
	@Before
	public void setUp() {
		
		movie = new Movie();
		ticketVendor = new TicketVendorImpl();
		returnTickets = new ArrayList<Ticket>();
	}
	
	@Test
	public void testTicket() throws TicketingException {
		
		movie.setMovieName("Rambo");
		movie.setId(34);
		
		ticketVendor.loadTickets(movie,TicketType.PLATINUM, 20.0, 10);
		returnTickets = ticketVendor.getTickets(movie, TicketType.PLATINUM, 7);
		Assert.assertEquals(7, returnTickets.size());
		//Assert.assertNotNull(tickets);
	}
	@Test(expected=TicketingException.class)
	public void testTickets2() throws TicketingException {
		movie.setMovieName("Rambo");
		movie.setId(34);
		returnTickets = ticketVendor.getTickets(movie, TicketType.PLATINUM, 7);
	}

	@Test(expected=TicketingException.class)
	public void testTickets3() throws TicketingException {
		movie.setMovieName("Rambo");
		movie.setId(34);
		ticketVendor.loadTickets(movie, TicketType.GOLD, 200.0, 10);
		returnTickets = ticketVendor.getTickets(movie, TicketType.PLATINUM, 10);
	}
	
	@Test(expected=TicketingException.class)
	public void testTickets4() throws TicketingException {
		movie.setMovieName("Rambo");
		movie.setId(34);
		
		Movie movie2 = new Movie();
		movie.setMovieName("Raja");
		ticketVendor.loadTickets(movie2, TicketType.GOLD, 200.0, 10);
		returnTickets = ticketVendor.getTickets(movie, TicketType.GOLD, 6);	
	}
}
