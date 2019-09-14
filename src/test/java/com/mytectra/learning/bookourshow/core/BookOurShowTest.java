package com.mytectra.learning.bookourshow.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.TicketType;
import com.mytectra.learning.bookourshow.offer.Buy2GetOneFreeOffer;
import com.mytectra.learning.bookourshow.offer.Offer;
import com.mytectra.learning.bookourshow.pricing.Pricing;
import com.mytectra.learning.bookourshow.pricing.PricingWithTax;
import com.mytectra.learning.bookourshow.tickets.TicketVendor;
import com.mytectra.learning.bookourshow.tickets.TicketVendorImpl;
import com.mytectra.learning.bookourshow.tickets.TicketingException;

public class BookOurShowTest {
	
	@Test
	public void testBooking() throws TicketingException {
		Movie movie = new Movie();
		movie.setMovieName("Rambo");
		movie.setId(34);
		
		List<Ticket> tickets = new ArrayList<Ticket>();
		for (int i = 0; i < 10; i++) {
			Ticket ticket = new Ticket(i, null, null, 0.0);
			tickets.add(ticket);
		}
		
		
		TicketVendor ticketVend = Mockito.mock(TicketVendor.class);
		Mockito.when(ticketVend.getTickets(movie, TicketType.PLATINUM, 10)).thenReturn(tickets);
		
		
		Offer offer = Mockito.mock(Offer.class);
		Pricing pricing = Mockito.mock(Pricing.class);
		
		
		BookOurShow bookOurShow = new BookOurShow(ticketVend, pricing, offer);
		
		Booking booking = bookOurShow.bookTickets(movie, TicketType.PLATINUM, 10);
		
		Assert.assertNotNull(booking);
		Assert.assertNotNull(booking.getId());
		Assert.assertNotNull(booking.getTickets());
		Assert.assertEquals(10, booking.getTickets().size());
		
		Mockito.verify(offer).applyOffer(booking);
		Mockito.verify(pricing).price(booking);

	}
	
	
}
