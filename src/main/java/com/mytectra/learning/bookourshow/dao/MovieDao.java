package com.mytectra.learning.bookourshow.dao;

import java.util.List;

import com.mytectra.learning.bookourshow.entity.Movie;

public interface MovieDao {
	
	Movie findMovieById(Integer id);
	
	int saveMovie(Movie movie);
	
	int update(Movie movie);
	
	int delete(Movie movie);
	
	List<Movie> getAllMovies();
}
