package com.mytectra.learning.bookourshow.offer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Ticket;


public class CashBackOfferTest {
	
	private Booking booking;
	private List<Ticket> tickets;
	private CashBackOffer cashbackoffer;
	
	
	
	@Before
	public void setUp() {
		
		 booking = new Booking();
		 tickets = new ArrayList<Ticket>();
		 cashbackoffer = new CashBackOffer();
		 cashbackoffer.setDiscount(5);
	}
	// 5 to 10 - if will add offer (String) (1) ? "You will get flash cash back of Rs. 150"
	
	    @Test
	    public void cashBackoffer150For6() {
		//added 6 tickts 
	    for(int i=0; i<6; i++)
		 {
			 Ticket ticket = new Ticket(i, null, null, 0.0);
			 tickets.add(ticket);
		 }
	    
		 booking.setTickets(tickets);
		 
		 //Apply offer
		cashbackoffer.applyOffer(booking);
		
		 
		 Assert.assertEquals(1 , booking.getOffersApplied().size());
		 String str1 = booking.getOffersApplied().get(0);

			 Assert.assertEquals("You will get flash cash back of Rs. 150", str1);
		 
		 
		
	}
	    @Test
	    public void cashBackoffer150For4() {
		 for(int i=0; i<4; i++)
		 {
			 Ticket ticket = new Ticket(i, null, null, 0.0);
			 tickets.add(ticket);
		 }
		 booking.setTickets(tickets);
		 cashbackoffer.applyOffer(booking);
		 Assert.assertEquals(0 , booking.getOffersApplied().size());	 
		
	}
	    
	    @Test
	    public void discountFor14() {
		 for(int i=0; i<14; i++)
		 {
			 Ticket ticket = new Ticket(i, null, null, 0.0);
			 tickets.add(ticket);
		 }
		 booking.setTickets(tickets);
		 cashbackoffer.applyOffer(booking);
		 Assert.assertEquals(1 , booking.getOffersApplied().size());
		 Assert.assertEquals(5.0, booking.getDiscount() ,0.0);
		 String str1 = booking.getOffersApplied().get(0);

		// Assert.assertEquals("You will get 5 discount", str1);
		 
		
	}
	

}
