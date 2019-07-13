package com.mytectra.learning.bookourshow.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mytectra.learning.bookourshow.core.BookOurShow;
import com.mytectra.learning.bookourshow.offer.Buy2GetOneFreeOffer;
import com.mytectra.learning.bookourshow.offer.CashBackOffer;
import com.mytectra.learning.bookourshow.offer.Offer;
import com.mytectra.learning.bookourshow.pricing.Pricing;
import com.mytectra.learning.bookourshow.pricing.PricingWithTax;
import com.mytectra.learning.bookourshow.tickets.TicketVendor;
import com.mytectra.learning.bookourshow.tickets.TicketVendorImpl;

@Configuration
public class bookOurShowConfig {
	
	@Bean
	public BookOurShow bos(TicketVendor ticketVendor, Pricing pricing,@Qualifier("cashbackoffer") Offer offer) 
	{
		return new BookOurShow(ticketVendor, pricing, offer);
		
	}
	
	@Bean
	public Pricing pricingWithText() {
		return new PricingWithTax();
	}
	
	@Bean
	public TicketVendor ticketVendorImpl() {
		 return new TicketVendorImpl();
	 }
	
	@Bean
	public Offer buy2GetOneFreeOffer() {
		return new Buy2GetOneFreeOffer();
	}
	
	@Bean
	@Primary
	public Offer cashbackoffer() {
		return new CashBackOffer();
	}
	 
	

}
