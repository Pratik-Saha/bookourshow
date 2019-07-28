package com.mytectra.learning.bookourshow.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.service.MovieService;

@RestController
@RequestMapping(path = "/bos")
public class MoviesController {

	@Autowired
	private MovieService service;

	@GetMapping(path = "/movies" , produces = {"application/xml"} , consumes = {"application/xml"} )
	public List<Movie> searchMovies(@RequestParam(required = false, name = "nameStartsWith") String movieName,
			@RequestParam(required = false, name = "actorNameStartsWith") String actorName ,
			@RequestParam(required = false, name = "dirNameStartsWith") String dirName) {

		List<Movie> movies = service.search(actorName, dirName, movieName);
		return movies;

	}
	
	

	@PostMapping(path = "/movies" , consumes = {"application/json"})
	public String loadMovie(@Validated @RequestBody Movie movie) {
		service.loadMovie(movie);
		return "{'status' : 'suceessfull'}";
	}

}
