package com.mytectra.learning.bookourshow.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.service.MovieService;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;

@Controller
public class WebController {

	@Autowired
	private MovieService service;

	@RequestMapping("/home")
	public ModelAndView listMovies() {
		ModelAndView modelAndView = new ModelAndView("movie_home");
		modelAndView.addObject("movies", service.listMovie());
		return modelAndView;
	}

	@RequestMapping("/movie_form")
	public ModelAndView getForm() {
		Movie movie = new Movie();
		// Internal
		ModelAndView modelAndView = new ModelAndView("forward:/home");
		modelAndView.addObject("movie", movie);
		return modelAndView;
	}

	@RequestMapping("/movie_load")
	public ModelAndView loadMovie(@Validated @ModelAttribute Movie movie, BindingResult result , Model model ) {
		// From Browserde

		ModelAndView modelAndView = new ModelAndView();
		
		try {
			if (!result.hasErrors()) {
				service.loadMovie(movie);
				modelAndView.setViewName("redirect:/home");
				modelAndView.addObject("message", "Movie added sucessfully");
			} else {
				return new ModelAndView("forward:/home");
			}
		} catch (Exception e) {
			return new ModelAndView("error");
		}
		return modelAndView;
	}

	@RequestMapping("/get_details")
	public ModelAndView getMovieDetails(@RequestParam("movie_id") int id) {
		ModelAndView mvm = new ModelAndView("movie");
		Movie movie = null;
		try {
			movie = service.getMovieById(id);
		} catch (MovieNotFoundException e) {

			return new ModelAndView("error");
		}
		mvm.addObject("movie", movie);
		return mvm;
	}

}
