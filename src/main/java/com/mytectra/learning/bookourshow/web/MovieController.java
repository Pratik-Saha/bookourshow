package com.mytectra.learning.bookourshow.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.service.MovieService;
import com.mytectra.learning.bookourshow.web.entity.Error;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper.Status;
import com.mytectra.learning.bookourshow.web.exception.MovieAlreadyExistsException;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;

@RestController
@RequestMapping(path = "/bookourshow")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping(path = "/searchMovies")
	public @ResponseBody ResponseWrapper<List<Movie>> movieByActorOrDirector(@RequestParam(required = false,name = "actorNameStartsWith") String actorName,
			@RequestParam(required = false,name = "directorNameStartsWith") String directorName,
			@RequestParam(required = false,name = "movieNameStartsWith") String movieName){
		
		List<Movie> movies = service.search(actorName, directorName, movieName);
		ResponseWrapper<List<Movie>> response = new ResponseWrapper<>();
		response.setStatus(Status.SUCCESS);
		response.setResponse(movies);
		return response;
	}
	
	@PostMapping(path = "/movies")
	public @ResponseBody ResponseWrapper<String> loadMovie(@Validated @RequestBody Movie movie) throws Exception {
		service.loadMovie(movie);
		ResponseWrapper<String> response = new ResponseWrapper<>();
		response.setStatus(Status.SUCCESS);
		response.setResponse("Movie Loaded Sucessfully");
		return response;
		
	}
	
	
	
	@DeleteMapping(path = "/movies/{movieId}")
	public @ResponseBody ResponseWrapper<String> deleteMovie(@PathVariable Integer movieId) throws Exception {
		ResponseWrapper<String> response = new ResponseWrapper<>();
		if(service.deleteMovie(movieId)) {
			response.setStatus(Status.SUCCESS);
			response.setResponse("Movie deleted successfully");
			//return response;
			//return "{'status' : 'movie deleted successfully'}"
		}
		/*else {
			response.setStatus(Status.ERROR);
			response.setErrorCode(1114);
			response.setErrorMessage("Movie not found!!");
			return response;
		}*/
		//return "{'status' : 'movie does not exists'}";
		return response;
	}
	
	@PutMapping(path = "/movies/{movieId}")
	public @ResponseBody ResponseWrapper<String> updateMovie(@PathVariable Integer movieId,@Validated @RequestBody Movie movie ) throws Exception {
		ResponseWrapper<String> response = new ResponseWrapper<>();
		if(service.updateMovie(movieId, movie)) {
			response.setStatus(Status.SUCCESS);
			response.setResponse("Movie details updated successfully");
			//return response;
			//return "{'status' : 'movie updated successfully'}"
		}
		/*else {
			response.setStatus(Status.ERROR);
			response.setErrorCode(1114);
			response.setErrorMessage("Movie not found!!");
			return response;
		}*/
		//return "{'status' : 'movie does not exists'}";
		return response;
		
	}
	
	@GetMapping(path = "/getMovieById/{movieId}")
	public @ResponseBody ResponseWrapper<Movie> getMovieById(@PathVariable Integer movieId) throws MovieNotFoundException {
		ResponseWrapper<Movie> response = new ResponseWrapper<>();
		Movie movie = service.getMovieById(movieId);
		/*if(movie != null) {
			response.setStatus(Status.SUCCESS);
			response.setResponse(movie);
			return response;
		}
		else {
			response.setStatus(Status.ERROR);
			response.setErrorCode(1114);
			response.setErrorMessage("Movie not found!!");
			return response;
		}*/
		response.setStatus(Status.SUCCESS);
		response.setResponse(movie);
		return response;
		
	}
	
	/*@ExceptionHandler(value = {HttpMessageNotReadableException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST )
	public ResponseWrapper<Error> handleException(Exception exception){
		System.out.println(exception.getClass());
		ResponseWrapper<Error> response = new ResponseWrapper<>();
		response.setStatus(Status.ERROR);
		com.mytectra.learning.bookourshow.web.entity.Error error = new Error();
		error.setErrorCode(1112);
		error.setErrorMessage(exception.getMessage());
		response.setResponse(error);
		return response;
		
		
	}*/
	
	/*@ExceptionHandler(value = {MovieNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseWrapper<Error> movieNotFoundException(Exception exception){
		ResponseWrapper<Error> response = new ResponseWrapper<>();
		response.setStatus(Status.INVALID_REQUEST);
		com.mytectra.learning.bookourshow.web.entity.Error error = new Error();
		error.setErrorCode(1114);
		error.setErrorMessage(exception.getMessage());
		response.setResponse(error);
		return response;
		 
	}*/
	
	@ExceptionHandler(value = {MovieAlreadyExistsException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseWrapper<Error> MovieAlreadyExistsException(Exception exception){
		ResponseWrapper<Error> response = new ResponseWrapper<>();
		response.setStatus(Status.ERROR);
		com.mytectra.learning.bookourshow.web.entity.Error error = new Error();
		error.setErrorCode(1113);
		error.setErrorMessage(exception.getMessage());
		response.setResponse(error);
		return response;
	}
}