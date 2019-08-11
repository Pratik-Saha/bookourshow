package com.mytectra.learning.bookourshow.offer;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Ticket;

public class Buy2GetOneFreeOfferTest {

	private Buy2GetOneFreeOffer buy2GetOneFreeOffer;

	private Booking booking;

	private List<Ticket> tickets;

	@Before
	public void setup() {
		System.out.println("Before any test");
		buy2GetOneFreeOffer = new Buy2GetOneFreeOffer();
		booking = new Booking();
		tickets = new ArrayList<Ticket>();
	}

	@After
	public void fi() {
		System.out.println("Test over");
	}

	@Test
	public void testTenTickets3Discount() {

		for (int i = 0; i < 10; i++) {
			Ticket ticket = new Ticket(i, null, null, 0.0);
			tickets.add(ticket);
		}
		booking.setTickets(tickets);

		buy2GetOneFreeOffer.applyOffer(booking);

		int discountedTickets = 0;
		for (Ticket ticket : booking.getTickets()) {
			if (ticket.isDiscounted()) {
				discountedTickets++;
			}
		}

		Assert.assertEquals(3, discountedTickets);

	}

	@Test
	public void testOneTicket0Discount() {

		for (int i = 0; i < 1; i++) {
			Ticket ticket = new Ticket(i, null, null, 0.0);
			tickets.add(ticket);
		}
		booking.setTickets(tickets);

		buy2GetOneFreeOffer.applyOffer(booking);

		int discountedTickets = 0;
		for (Ticket ticket : booking.getTickets()) {
			if (ticket.isDiscounted()) {
				discountedTickets++;
			}
		}

		Assert.assertEquals(0, discountedTickets);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullBooking() {
		buy2GetOneFreeOffer.applyOffer(null);
	}

}
