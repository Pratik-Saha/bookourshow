package com.mytectra.learning.bookourshow.webmvc.scope;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Movie;

@Component
@Scope(scopeName = "session" ,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScope {
	
	private List<Movie> movies = new ArrayList<Movie>();
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public List<Movie> getMovies() {
		return movies;
	}

}
