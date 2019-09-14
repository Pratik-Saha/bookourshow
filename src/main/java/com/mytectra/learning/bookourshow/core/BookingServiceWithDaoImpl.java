package com.mytectra.learning.bookourshow.core;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.dao.BookingDao;
import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.offer.Offer;
import com.mytectra.learning.bookourshow.pricing.Pricing;
import com.mytectra.learning.bookourshow.tickets.TicketVendor;
import com.mytectra.learning.bookourshow.tickets.TicketingException;

@Component
@Transactional
public class BookingServiceWithDaoImpl {
	
	private TicketVendor ticketVendor;
	
	
	private Pricing pricing;
	
	
	private Offer offer;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	public BookingServiceWithDaoImpl(TicketVendor ticketVendor, Pricing pricing,@Qualifier("cashBackOffer") Offer offer) {
		super();
		this.ticketVendor = ticketVendor;
		this.pricing = pricing;
		this.offer = offer;
	}

	public Booking bookTickets(Movie movie , TicketType ticketType ,  int numberOfTickets) throws TicketingException {
		 List<Ticket> tickets = ticketVendor.getTickets(movie, ticketType, numberOfTickets);
		 Booking booking = new Booking();
		 //booking.setId(76885);
		 booking.setTickets(tickets);
		 
		 offer.applyOffer(booking);
		 pricing.price(booking);
		 for(Ticket ticket : booking.getTickets()) {
			 ticket.setBooking(booking);
		 }
		 bookingDao.saveBooking(booking);
		 
		 return booking;
	}


}
