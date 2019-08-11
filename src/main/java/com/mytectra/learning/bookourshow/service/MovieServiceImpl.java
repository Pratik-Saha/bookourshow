package com.mytectra.learning.bookourshow.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.web.exception.MovieAlreadyExistsException;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;

@Component
public class MovieServiceImpl implements MovieService {

	private List<Movie> movies = new ArrayList<Movie>();

	@PostConstruct
	public void init() {

		System.out.println("This is called after creation of the bean");

		Movie movie1 = new Movie();
		movie1.setId(1);
		movie1.setMovieName("msdtus");
		movie1.setInfo("English");
		movie1.setActorName("susant");
		movie1.setDirectorName("karan");
		movie1.setImdb(7);
		movie1.setReleaseDate(new Date(2019 - 10 - 12));

		Movie movie2 = new Movie();
		movie2.setId(2);
		movie2.setMovieName("super30");
		movie2.setInfo("English");
		movie2.setActorName("ritwick");
		movie2.setDirectorName("kjr");
		movie2.setImdb(9);
		movie2.setReleaseDate(new Date(2019 - 12 - 25));

		movies.add(movie1);
		movies.add(movie2);

	}

	@Override
	public void loadMovie(Movie movie) throws MovieAlreadyExistsException {
		/*Movie mov = getMovieById(movie.getId());
		if (mov != null) {
			throw new MovieAlreadyExistsException("Movie already exists with same Id " + mov.getMovieName());
		}*/
		List<Movie> movies = listMovie();
		Iterator<Movie> itr2 = movies.iterator();
		while (itr2.hasNext()) {
			Movie mov = itr2.next();
			if (mov.getId() == movie.getId()) {
				throw new MovieAlreadyExistsException("same id movie already exists");
			}
		}
		this.movies.add(movie);
	}

	@Override
	public List<Movie> listMovie() {

		return new ArrayList<Movie>(movies);
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
		List<Movie> movies = listMovie();
		Iterator<Movie> itr2 = movies.iterator();
		while (itr2.hasNext()) {
			Movie movie = itr2.next();
			if (movie.getId() == id) {
				return movie;
			}
		
		}
		//return null;
		throw new MovieNotFoundException("movie not found!!");
	}

	@Override
	public boolean deleteMovie(int id) throws MovieNotFoundException {
		Movie movie = getMovieById(id);
		if(movie != null) {
			movies.remove(movie);
			//return true;
		}
		return true;
	}

	@Override
	public boolean updateMovie(int id , Movie movie) throws MovieNotFoundException {
		Movie mov = getMovieById(id);
		if(mov.getId() == movie.getId()) {
			movies.remove(mov);
			movies.add(movie);
			//return true;
		}
		return true;
		
	}

}
