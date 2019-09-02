package com.mytectra.learning.bookourshow.dao.jdbc;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.dao.TicketDao;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.web.entity.TicketLoadRequest;

@Component
public class TicketDaoJDBCImpl implements TicketDao {

	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private TicketMapper ticketMapper;
	
	private final String LOAD_TICKET = "insert into Ticket (movieId,movieName,price,ticketType) values (?,?,?,?)"; 
	
	private final String GET_TICKET = "select * from Ticket where movieId = ? AND ticketType = ? LIMIT ?";
	
	@Override
	public int saveTicket(Ticket ticket) {
		return template.update(LOAD_TICKET,new Object[] {ticket.getMovie().getId(),ticket.getMovie().getMovieName(),ticket.getPrice(),ticket.getTicketType().toString()
			});
	
	}

	@Override
	public List<Ticket> getTicket(Movie movie,TicketType ticketType, int count) {
		List<Ticket> ticket = template.query(GET_TICKET, new Object[] {movie.getId(),ticketType.name(),count}, ticketMapper);
		if(ticket == null || ticket.isEmpty() || ticket.size() < count) {
			return null;
		}
		return ticket;
		
	}

}
