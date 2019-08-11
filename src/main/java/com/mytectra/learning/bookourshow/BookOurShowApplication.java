package com.mytectra.learning.bookourshow;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mytectra.learning.bookourshow.core.BookOurShow;
import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.offer.CashBackOffer;
import com.mytectra.learning.bookourshow.tickets.TicketVendor;
import com.mytectra.learning.bookourshow.tickets.TicketingException;


@SpringBootApplication(scanBasePackages = "com.mytectra.learning.bookourshow" )
public class BookOurShowApplication {

	public static void main(String[] args) throws TicketingException {
		ConfigurableApplicationContext ctx = SpringApplication.run(BookOurShowApplication.class, args);
		/*BookOurShow bookOurShow = (BookOurShow) ctx.getBean("bos");

		TicketVendor ticketVend = ctx.getBean(TicketVendor.class);
		
		Movie movie = new Movie();
		movie.setId(12);
		movie.setMovieName("Rambo");
				
		ticketVend.loadTickets(movie, TicketType.PLATINUM, 200.0, 15);
		ticketVend.loadTickets(movie, TicketType.GOLD, 150.30, 15);

		Booking booking = bookOurShow.bookTickets(movie, TicketType.GOLD, 12);
		System.out.println("______________________________________");
		System.out.println("Booking Id - " + booking.getId());
		System.out.println("Movie Name - " + movie.getMovieName());
		System.out.println("Tickets - " + booking.getTickets().size());
		System.out.println("Price - " + booking.getPrice() + " Rs");
		System.out.println(String.format("Discount (%f%%) -  %f",booking.getDiscount() ,booking.getDiscountedPrice()));
		System.out.println("Tax - " + booking.getTax() + " Rs");
		System.out.println("------------------------------------");
		System.out.println("TOTAL - "+ booking.getGrandTotal());
		System.out.println("______________________________________");
		for(String msg : booking.getOffersApplied()) {
			System.out.println("* "+msg);
		}
		for(String msg : booking.getPricingInfo()) {
			System.out.println("* "+msg);
		}
			
		*/
	}

}
