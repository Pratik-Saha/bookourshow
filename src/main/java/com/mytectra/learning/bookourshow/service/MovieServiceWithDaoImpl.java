package com.mytectra.learning.bookourshow.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.dao.MovieDao;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.web.exception.MovieAlreadyExistsException;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;

@Component
public class MovieServiceWithDaoImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;

	@PostConstruct
	public void init() {

		System.out.println("This is called after creation of the bean");

	}

	@Override
	public void loadMovie(Movie movie) throws MovieAlreadyExistsException {
		try {
			Movie mov = getMovieById(movie.getId());
		} catch (MovieNotFoundException e) {
			movieDao.saveMovie(movie);
		}
		
	}

	@Override
	public List<Movie> listMovie() {
		return movieDao.getAllMovies();
	}

	@Override
	public List<Movie> search(String actorNameStartsWith, String dirNameStartsWith, String movieNameStartsWith) {

		List<Movie> movies = listMovie();

		if (StringUtils.isNotEmpty(actorNameStartsWith)) {
			Iterator<Movie> itr = movies.iterator();
			while (itr.hasNext()) {
				Movie movie = itr.next();
				if (!movie.getActorName().startsWith(actorNameStartsWith)) {
					itr.remove();
				}
			}
		}

		if (StringUtils.isNotEmpty(dirNameStartsWith)) {
			Iterator<Movie> itr = movies.iterator();
			while (itr.hasNext()) {
				Movie movie = itr.next();
				if (!movie.getDirectorName().startsWith(dirNameStartsWith)) {
					itr.remove();
				}
			}
		}

		if (StringUtils.isNotEmpty(movieNameStartsWith)) {
			Iterator<Movie> itr = movies.iterator();
			while (itr.hasNext()) {
				Movie movie = itr.next();
				if (!movie.getMovieName().startsWith(movieNameStartsWith)) {
					itr.remove();
				}
			}
		}
		return movies;
	}

	@Override
	public Movie getMovieById(int id) throws MovieNotFoundException {
		Movie movie = movieDao.findMovieById(id);
		if(movie == null) {
			throw new MovieNotFoundException("Movie Does not exists for Id " + id );
		}
		return movie;
	}

	@Override
	public boolean deleteMovie(int id) throws MovieNotFoundException {
		Movie movie = getMovieById(id);
		if(movie != null) {
			movieDao.delete(movie);
			//return true;
		}
		return true;
	}

	@Override
	public boolean updateMovie(int id , Movie movie) throws MovieNotFoundException {
		Movie mov = getMovieById(id);
		if(mov.getId() == movie.getId()) {
			movieDao.update(movie);
		}
		return true;
		
	}

}
