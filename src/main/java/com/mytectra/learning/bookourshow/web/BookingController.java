package com.mytectra.learning.bookourshow.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytectra.learning.bookourshow.core.BookOurShow;
import com.mytectra.learning.bookourshow.core.BookingServiceWithDaoImpl;
import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.service.MovieService;
import com.mytectra.learning.bookourshow.tickets.TicketingException;
import com.mytectra.learning.bookourshow.web.entity.BookingRequest;
import com.mytectra.learning.bookourshow.web.entity.Error;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper.Status;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;

@RestController
@RequestMapping(path = "/bookourshow")
public class BookingController {
	
	//@Autowired  
	//BookOurShow bookOurShowService;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	BookingServiceWithDaoImpl bookingService;
	
	@PostMapping(path = "/booking")
	public  @ResponseBody ResponseWrapper<String> booktickets(@Validated @RequestBody BookingRequest request) throws TicketingException, MovieNotFoundException  
	{
		ResponseWrapper<String> response = new ResponseWrapper<>();
		Movie movie = movieService.getMovieById(request.getMovieId());
		/*if(movie == null)
		{
			throw new TicketingException("Movie not found");
		}	*/
		 //bookOurShowService.bookTickets(movie, request.getTicketType(), request.getCount());
		 
		bookingService.bookTickets(movie, request.getTicketType(), request.getCount());
		response.setStatus(Status.SUCCESS);
		//response.setResponse(booking);
		return response;
		//return booking;
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
	
	@ExceptionHandler(value = {TicketingException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseWrapper<Error> ticketNotFoundException(Exception exception){
		ResponseWrapper<Error> response = new ResponseWrapper<>();
		response.setStatus(Status.ERROR);
		com.mytectra.learning.bookourshow.web.entity.Error error = new Error();
		error.setErrorCode(1115);
		error.setErrorMessage(exception.getMessage());
		response.setResponse(error);
		return response;
		 
	}
	
	  

}
