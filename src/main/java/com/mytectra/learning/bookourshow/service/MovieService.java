package com.mytectra.learning.bookourshow.service;

import java.util.List;

import com.mytectra.learning.bookourshow.entity.Movie;

public interface MovieService {
	
	void loadMovie(Movie movie);
	
	List<Movie> listMovies();
	
	Movie getMovieById(int id);
	
	List<Movie> search(String actorNameStartsWith , String dirStartsWith , String movieNameStartsWith);
	
}
