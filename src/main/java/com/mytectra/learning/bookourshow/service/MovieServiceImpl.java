package com.mytectra.learning.bookourshow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Movie;

@Component
public class MovieServiceImpl implements MovieService {

	private List<Movie> movies = new ArrayList<Movie>();
	
	@Override
	public void loadMovie(Movie movie) {
		movies.add(movie);
	}

	@Override
	public List<Movie> listMovies() {
		return new ArrayList<Movie>(movies);
	}

}
