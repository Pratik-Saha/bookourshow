package com.mytectra.learning.bookourshow.webmvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.service.MovieService;
import com.mytectra.learning.bookourshow.web.entity.Error;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper.Status;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;
import com.mytectra.learning.bookourshow.webmvc.scope.RequestScope;
import com.mytectra.learning.bookourshow.webmvc.scope.SessionScope;

@Controller
public class WebController {

	@Autowired
	private MovieService service;

	@Autowired
	private RequestScope requestScope;
	
	@Autowired
	private SessionScope sessionScope;
	
	@RequestMapping("/home")
	public ModelAndView listMovies() {
		ModelAndView modelAndView = new ModelAndView("movie_home");
		modelAndView.addObject("movies", service.listMovie());
		return modelAndView;
	}

	@RequestMapping("/movie_form")
	public ModelAndView getForm(@RequestParam(required = false) Integer id) throws MovieNotFoundException {
		Movie movie = new Movie();
		ModelAndView modelAndView = new ModelAndView("forward:/home");
		if(id != null) {
			movie = service.getMovieById(id);
			modelAndView.addObject("editAction", true);
		} 
		modelAndView.addObject("movie", movie);

		// Interna
		
		return modelAndView;
	}

	@RequestMapping("/movie_load")
	public ModelAndView loadMovie(@Validated @ModelAttribute Movie movie, BindingResult result ) {
		// From Browser

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
			e.printStackTrace();
			return new ModelAndView("error");
		}
		return modelAndView;
	}
	
	@RequestMapping("/movie_edit")
	public ModelAndView editMovie(@Validated @ModelAttribute Movie movie, BindingResult result ) {
		// From Browser

		ModelAndView modelAndView = new ModelAndView();
		
		try {
			if (!result.hasErrors()) {
				service.updateMovie(movie.getId(), movie);
				modelAndView.setViewName("redirect:/home");
				modelAndView.addObject("message", "Movie updated sucessfully");
			} else {
				return new ModelAndView("forward:/home");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	
	@RequestMapping("/movie_delete")
	public ModelAndView deleteMovie(@RequestParam(required = true) Integer id) throws MovieNotFoundException {
		
		service.deleteMovie(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		modelAndView.addObject("message","movie deleted");
		return modelAndView;
	}
	
	//Non spring
	/*
	 * @RequestMapping("/movie_cart") 
	 * public String cart(@RequestParam(required = true) Integer id , HttpSession session , HttpServletRequest request ) throws MovieNotFoundException { 
	 * Movie movie = service.getMovieById(id); 
	 * List<Movie> requestScope = (List<Movie>)request.getAttribute("rc_movies"); 
	 * if(requestScope == null) { 
	 * requestScope = new ArrayList<Movie>(); 
	 * }
	 * requestScope.add(movie);
	 * request.setAttribute("rc_movies", requestScope);
	 * 
	 * List<Movie> sessionScope = (List<Movie>)session.getAttribute("session_movies"); 
	 * if(sessionScope == null) {
	 * sessionScope = new ArrayList<Movie>(); 
	 * }
	 *  sessionScope.add(movie);
	 * session.setAttribute("session_movies", sessionScope); 
	 * 
	 * 	return "forward:/home";
	 * }
	 */
	
	@RequestMapping("/movie_cart")
	public ModelAndView cart(@RequestParam(required = true) Integer id ) throws MovieNotFoundException {
		Movie movie = service.getMovieById(id);
		requestScope.addMovie(movie);
		sessionScope.addMovie(movie);
		ModelAndView mvm = new ModelAndView("forward:/home");
		mvm.addObject("requestSpe", requestScope);
		mvm.addObject("sessionSpe", sessionScope);

		return mvm;
	}
	
	@ExceptionHandler(value = {MovieNotFoundException.class})
	public ModelAndView movieNotFoundException(Exception exception){
		ModelAndView mvm = new ModelAndView("redirect:/home");
		mvm.addObject("message", exception.getMessage());
		return mvm;
	}
	
	

}
