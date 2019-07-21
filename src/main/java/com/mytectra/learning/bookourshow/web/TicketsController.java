package com.mytectra.learning.bookourshow.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;

@Controller
@RequestMapping(path = "/bos")
public class TicketsController {
	
	@GetMapping(path = "/tickets")
	public @ResponseBody List<Ticket> tickets(){
		
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		Movie movie = new Movie();
	    movie.setId(01);
		movie.setMovieName("Rugby");
		
		Ticket ticket = new Ticket(1,movie,TicketType.GOLD,200);
		
		Movie movie2 = new Movie();
	    movie2.setId(02);
		movie2.setMovieName("Rambo");
		
		Ticket ticket2 = new Ticket(2,movie2,TicketType.GOLD,200);
		
		Movie movie3 = new Movie();
	    movie3.setId(03);
		movie3.setMovieName("Romeo");		
		
		Ticket ticket3 = new Ticket(3,movie3,TicketType.GOLD,200);
		
		tickets.add(ticket);
		tickets.add(ticket2);
		tickets.add(ticket3);
		
		return tickets;
		
		
		
	}

}
