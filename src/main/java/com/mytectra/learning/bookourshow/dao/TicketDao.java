package com.mytectra.learning.bookourshow.dao;

import java.util.List;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.web.entity.TicketLoadRequest;

public interface TicketDao {
	
	int saveTicket(Ticket ticket);
	
	List<Ticket> getTicket(Movie movie,TicketType ticketType, int count);

}
