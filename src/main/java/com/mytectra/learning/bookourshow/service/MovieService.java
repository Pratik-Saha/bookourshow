package com.mytectra.learning.bookourshow.service;

import java.util.List;

import com.mytectra.learning.bookourshow.entity.Movie;

public interface MovieService {

	void loadMovie(Movie movie);
	
	//Tempory
	List<Movie> listMovies();
	
	//List<Movie> search(SearchCitera sc)
}
