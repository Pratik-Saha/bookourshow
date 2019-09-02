package com.mytectra.learning.bookourshow.tickets;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.dao.TicketDao;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.web.entity.TicketLoadRequest;

@Component
@Transactional
public class TicketServiceWithDaoImpl implements TicketVendor {
	
	@Autowired
	private TicketDao ticketDao;

	@Override
	public List<Ticket> getTickets(Movie movie, TicketType ticketType, int count) throws TicketingException {
		return ticketDao.getTicket(movie,ticketType,count);
	}

	@Override
	public void loadTickets(Movie movie, TicketType ticketType, double price, int count) throws TicketingException {
		for(int i=0;i<count;i++) {
			Ticket ticket = new Ticket( movie,ticketType,price);
			ticketDao.saveTicket(ticket);
		}
		
	}

}
