package com.mytectra.learning.bookourshow.pricing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Ticket;

@Component
public class PricingWithTax  implements Pricing{

	@Value("${gov.india.tax}")
	private double tax;
	
	
	@Override
	public void price(Booking booking) {
		double price = 0;
		for (Ticket ticket : booking.getTickets()) {
			if (!ticket.isDiscounted()) {
				price += ticket.getPrice();
			}
		}
		booking.setPrice(price);
		double taxedAmt = price * (tax/100);
		booking.appendPricingInfo(String.format("%f Tax applied = %f ",tax , taxedAmt ));
		booking.setTax(taxedAmt);
	}

}
