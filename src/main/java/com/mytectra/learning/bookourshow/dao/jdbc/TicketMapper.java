package com.mytectra.learning.bookourshow.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.TicketType;
import com.mytectra.learning.bookourshow.web.entity.TicketLoadRequest;

@Component
public class TicketMapper implements RowMapper<Ticket> {

	@Override
	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ticket ticket = new Ticket();
		Movie movie = new Movie();
		movie.setId(rs.getInt("movieId"));
		movie.setMovieName(rs.getString("movieName"));
		
		ticket.setId(rs.getInt("ticketId"));
		ticket.setMovie(movie);
		ticket.setPrice(rs.getDouble("price"));
		ticket.setTicketType(TicketType.valueOf(rs.getString("ticketType")));
		return ticket;
	}

}
