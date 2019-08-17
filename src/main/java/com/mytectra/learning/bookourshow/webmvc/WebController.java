package com.mytectra.learning.bookourshow.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String home() {
		return "index";
	}
	
	@RequestMapping("/home2")
	public ModelAndView home2() {
		ModelAndView mvm = new ModelAndView("index");
		mvm.addObject("name", "Jayaram");
		return mvm;
	}
	
	@RequestMapping("/get_form")
	public String getForm() {
		return "movieForm";
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
