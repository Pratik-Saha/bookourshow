package com.mytectra.learning.bookourshow.pricing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Ticket;

public class PricingWithTaxTest {

	private Booking booking;
	private PricingWithTax pricingWithTax;
	private List<Ticket> tickets;
	
	
	
	@Before
	public void setup(){
		booking = new Booking();
		pricingWithTax = new PricingWithTax();	
		tickets = new ArrayList<Ticket>();
		pricingWithTax.setTax(10);
		}
	
	@Test
	public void priceof10Tickets()
	{
		for(int i=0;i<10;i++)
		{
			Ticket ticket = new Ticket(i, null, null, 10);
			tickets.add(ticket);
		}
		  booking.setTickets(tickets);
		  pricingWithTax.price(booking);
		   Assert.assertEquals(100, booking.getPrice(), 0.0);
		   Assert.assertEquals(0.0, booking.getDiscountedPrice(), 0.0);
		   Assert.assertEquals(110, booking.getGrandTotal(), 0.0);
		   Assert.assertEquals(10, booking.getTax(), 0.0);
		   
	}
	
	@Test
	public void priceof10TicketsWithDiscount()
	{
		booking.setDiscount(20);
		
		for(int i=0;i<10;i++)
		{
			Ticket ticket = new Ticket(i, null, null, 10);
			tickets.add(ticket);
		}
		  booking.setTickets(tickets);
		  pricingWithTax.price(booking);
		   Assert.assertEquals(100, booking.getPrice(), 0.0);
		   Assert.assertEquals(20.0, booking.getDiscountedPrice(), 0.0);
		   Assert.assertEquals(88.0, booking.getGrandTotal(), 0.0);
		   Assert.assertEquals(8.0, booking.getTax(), 0.0);
		   
	}
	
	@Test
	public void priceof10TicketsWithDiscountedTickets()
	{
		
		for(int i=0;i<3;i++)
		{
			Ticket ticket = new Ticket(i, null, null, 10);
			ticket.setDiscounted(true);
			tickets.add(ticket);
		}
		for(int i=0;i<7;i++)
		{
			Ticket ticket = new Ticket(i, null, null, 10);
			ticket.setDiscounted(false);
			tickets.add(ticket);
		}
		  booking.setTickets(tickets);
		  pricingWithTax.price(booking);
		   Assert.assertEquals(70, booking.getPrice(), 0.0);
		   Assert.assertEquals(0.0, booking.getDiscountedPrice(), 0.0);
		   Assert.assertEquals(77.0, booking.getGrandTotal(), 0.0);
		   Assert.assertEquals(7.0, booking.getTax(), 0.0);
		   
	}
	
}
