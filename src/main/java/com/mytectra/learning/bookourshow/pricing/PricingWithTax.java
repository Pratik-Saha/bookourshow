package com.mytectra.learning.bookourshow.pricing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Ticket;

@Component
public class PricingWithTax  implements Pricing{

	@Value("${gov.india.tax}")
	private double tax;
	
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public void price(Booking booking) {
		double price = 0;
		double discoundtedPrice = 0;

		for (Ticket ticket : booking.getTickets()) {
			if (!ticket.isDiscounted()) {
				price += ticket.getPrice();
			}
		}
		if(booking.getDiscount() > 0) {
			discoundtedPrice = price * (booking.getDiscount()/100);
			booking.setDiscountedPrice(discoundtedPrice);
		}
		
		booking.setPrice(price);
		double priceAfterDiscount = price - discoundtedPrice;
		double taxedAmt = priceAfterDiscount * (tax/100);
		double grandTotal = priceAfterDiscount + taxedAmt;
		booking.setTax(taxedAmt);
		booking.setGrandTotal(grandTotal);
		booking.appendPricingInfo(String.format("%f Tax applied = %f ",tax , taxedAmt ));
	}

}
