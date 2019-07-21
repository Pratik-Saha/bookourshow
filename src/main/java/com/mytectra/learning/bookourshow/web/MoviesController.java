package com.mytectra.learning.bookourshow.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.service.MovieService;

@Controller
@RequestMapping(path = "/bos")
public class MoviesController {

	@Autowired
	private MovieService service;

	@GetMapping(path = "/movies")
	public @ResponseBody List<Movie> searchMovies(@RequestParam(required = false, name = "startsWith") String str) {
		List<Movie> movies = service.listMovies();

		if (str != null) {
			Iterator<Movie> itr = movies.iterator();
			while (itr.hasNext()) {
				Movie movie = itr.next();
				if (!movie.getMovieName().startsWith(str)) {
					itr.remove();
				}
			}
		}

		/*
		 * return movies .stream() .filter(movie ->
		 * !movie.getMovieName().startsWith(str)) .collect(Collectors.toList());
		 */
		return movies;

	}

	@PostMapping(path = "/movies")
	public @ResponseBody String loadMovie(@RequestBody Movie movie) {
		service.loadMovie(movie);
		return "{'status' : 'suceessfull'}";
	}

}
