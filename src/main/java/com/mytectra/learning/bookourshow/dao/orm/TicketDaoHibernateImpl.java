package com.mytectra.learning.bookourshow.dao.orm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.dao.TicketDao;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;

@Component
@Primary
public class TicketDaoHibernateImpl implements TicketDao {
	
	@Autowired
	private EntityManager manager;

	@Override
	public int saveTicket(Ticket ticket) {
		manager.persist(ticket);
		return 0;
	}

	@Override
	public List<Ticket> getTicket(Movie movie, TicketType ticketType, int count) {
		Query query = manager.createNamedQuery("load_tickets");
		query.setParameter(1, movie);
		query.setParameter(2, ticketType);
		query.setMaxResults(count);
		try {
			return query.getResultList();
		}catch (NoResultException ex) {
			return null;
		}
	}

}
