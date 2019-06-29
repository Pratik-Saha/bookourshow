package com.mytectra.learning.bookourshow.pricing;

import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Ticket;

public class SimplePricing  implements Pricing{

	@Override
	public void price(Booking booking) {
		double price = 0;
		for(Ticket  ticket :booking.getTickets())
		{
			price += ticket.getPrice();
		}
		booking.setPrice(price);
	}

}
