package com.mytectra.learning.bookourshow.service;

import java.util.List;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;

public interface MovieService {
	
	public void loadMovie(Movie movie) throws Exception;
	
	public List<Movie> listMovie();
	
	public boolean deleteMovie(int id) throws MovieNotFoundException;
	
	public boolean updateMovie(int id, Movie movie) throws MovieNotFoundException;
	
	public List<Movie> search(String actorNameStartsWith, String dirNameStartsWith, String movieNameStartsWith);

	Movie getMovieById(int id) throws MovieNotFoundException;
}
