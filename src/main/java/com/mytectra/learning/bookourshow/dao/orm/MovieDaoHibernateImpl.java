package com.mytectra.learning.bookourshow.dao.orm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.ejb.HibernateEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.dao.MovieDao;
import com.mytectra.learning.bookourshow.entity.Movie;

@Component
@Primary
public class MovieDaoHibernateImpl  implements MovieDao{

	
	@Autowired
	private EntityManager manager;
	
	
	
	@Override
	public Movie findMovieById(Integer id) {
		TypedQuery<Movie> query = manager.createQuery("FROM Movie m where m.id = :id", Movie.class);
		try{
			return query.setParameter("id", id).getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
		
	}

	@Override
	public int saveMovie(Movie movie) {
		manager.persist(movie);
		return 1;
	}

	@Override
	public int update(Movie movie) {
		manager.merge(movie);
		return 1;
	}

	@Override
	public int delete(Movie movie) {
		manager.remove(movie);
		return 1;
	}

	@Override
	public List<Movie> getAllMovies() {
		TypedQuery<Movie> query = manager.createQuery("FROM Movie m", Movie.class);
		return query.getResultList();		
	}

}
