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
	private double price = 0;
	private List<Ticket> tickets;
	
	
	
	@Before
	public void setup(){
		booking = new Booking();
		pricingWithTax = new PricingWithTax();	
		tickets = new ArrayList<Ticket>();
		pricingWithTax.setTax(10);
		}
	
	@Test
	public void priceofTickets()
	{
		for(int i=0;i<12;i++)
		{
			Ticket ticket = new Ticket(i, null, null, 10);
			tickets.add(ticket);
		}
		  booking.setTickets(tickets);
		  pricingWithTax.price(booking);
		   Assert.assertEquals(120, booking.getPrice(), 0.0);
		   Assert.assertEquals(0.0, booking.getDiscountedPrice(), 0.0);
		   Assert.assertEquals(132, booking.getGrandTotal(), 0.0);
		   Assert.assertEquals(12, booking.getTax(), 0.0);
		  
	}
	
	
	@Test
	public void DiscountedpriceofTickets()
	{
		booking.setDiscount(10);
		
		for(int i=0;i<12;i++)
		{
			Ticket ticket = new Ticket(i, null, null, 10);
			tickets.add(ticket);
		}
		  booking.setTickets(tickets);
		  pricingWithTax.price(booking);
		   Assert.assertEquals(120, booking.getPrice(), 0.0);
		   Assert.assertEquals(12, booking.getDiscountedPrice(), 0.0);
		   Assert.assertEquals(118.8, booking.getGrandTotal(), 0.0);
		   Assert.assertEquals(10.8, booking.getTax(), 0.0);
			  
	}
	
	
	@Test
	public void DiscountedTickets10()
	{
		//booking.setDiscount(10);
		
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
		   Assert.assertEquals(77, booking.getGrandTotal(), 0.0);
		   Assert.assertEquals(7, booking.getTax(), 0.0);
			  
	}
	
	
	@Test(expected = NullPointerException.class)
	public void testNullBooking() {
		pricingWithTax.price(null);
	}
	
}
