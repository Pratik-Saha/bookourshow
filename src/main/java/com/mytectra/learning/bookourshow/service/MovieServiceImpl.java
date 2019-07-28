package com.mytectra.learning.bookourshow.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Movie;

@Component
public class MovieServiceImpl implements MovieService {

	private List<Movie> movies = new ArrayList<Movie>();
	

	@PostConstruct
	public void init() {
		System.out.println("THis will be called right after the bean creation");
		//I want to load some deafilt movies
		Movie movie = new Movie();
		movie.setId(1);
		movie.setActorName("SRK");
		movie.setDirectorName("KJ");
		movie.setMovieName("DDLJ");
		movie.setImdb(8);
		movie.setReleaseDate(new Date(1989,05,20));
		movies.add(movie);
		
		Movie movie2 = new Movie();
		movie2.setId(2);
		movie2.setActorName("SLK");
		movie2.setDirectorName("KJJ");
		movie2.setMovieName("DDLJ5");
		movie2.setImdb(5);
		movie2.setReleaseDate(new Date(1989,05,22));
		movies.add(movie2);
	}

	
	@Override
	public void loadMovie(Movie movie) {
		movies.add(movie);
	}

	@Override
	public List<Movie> listMovies() {
		return new ArrayList<Movie>(movies);
	}

	@Override
	public List<Movie> search(String actorNameStartsWith, String dirStartsWith, String movieNameStartsWith) {
		List<Movie> movies =  listMovies();
		if(StringUtils.isNotEmpty(actorNameStartsWith)) {
			Iterator<Movie> itr2 = movies.iterator();
			while(itr2.hasNext()) {
				Movie movie = itr2.next();
				if(!movie.getActorName().startsWith(actorNameStartsWith)) {
					itr2.remove();
				}
			}
		}
		if(StringUtils.isNotEmpty(dirStartsWith)) {
			Iterator<Movie> itr2 = movies.iterator();
			while(itr2.hasNext()) {
				Movie movie = itr2.next();
				if(!movie.getDirectorName().startsWith(dirStartsWith)) {
					itr2.remove();
				}
			}
		}
		if(StringUtils.isNotEmpty(movieNameStartsWith)) {
			Iterator<Movie> itr2 = movies.iterator();
			while(itr2.hasNext()) {
				Movie movie = itr2.next();
				if(!movie.getMovieName().startsWith(movieNameStartsWith)) {
					itr2.remove();
				}
			}
		}
		
		return movies;
	}


	@Override
	public Movie getMovieById(int id) {
		List<Movie> movies =  listMovies();
		Iterator<Movie> itr2 = movies.iterator();
		while(itr2.hasNext()) {
			Movie movie = itr2.next();
			if(movie.getId() == id) {
				return movie;
			}
		}
		return null;
	}

}
