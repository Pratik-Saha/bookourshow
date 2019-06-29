package com.mytectra.learning.bookourshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mytectra.learning.bookourshow.core.BookOurShow;
import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.tickets.TicketVendor;
import com.mytectra.learning.bookourshow.tickets.TicketingExecption;

/**
 * 
 * @author happy
 *
 */
@SpringBootApplication
public class BookOurShowApplication {

	public static void main(String[] args) throws TicketingExecption {
		ConfigurableApplicationContext ctx = SpringApplication.run(BookOurShowApplication.class, args);
		BookOurShow bookOurShow = (BookOurShow) ctx.getBean("bookOurShow");

		TicketVendor ticketVend = ctx.getBean(TicketVendor.class);
		
		Movie movie = new Movie();
		movie.setId(12);
		movie.setMovieName("Rambo");
				
		ticketVend.loadTickets(movie, TicketType.PLATINUM, 200.0, 6);
		ticketVend.loadTickets(movie, TicketType.GOLD, 150.30, 6);

		Booking booking = bookOurShow.bookTickets(movie, TicketType.GOLD, 3);
		System.out.println("______________________________________");
		System.out.println("Booking Id - " + booking.getId());
		System.out.println("Movie Name - " + movie.getMovieName());
		System.out.println("Price - " + booking.getPrice() + " Rs");
		System.out.println("______________________________________");
	}

}
