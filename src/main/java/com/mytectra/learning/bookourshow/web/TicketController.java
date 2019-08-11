package com.mytectra.learning.bookourshow.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.service.MovieService;
import com.mytectra.learning.bookourshow.tickets.TicketVendor;
import com.mytectra.learning.bookourshow.tickets.TicketingException;
import com.mytectra.learning.bookourshow.web.entity.Error;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper.Status;
import com.mytectra.learning.bookourshow.web.entity.TicketLoadRequest;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;

@RestController
@RequestMapping(path = "/bookourshow")
public class TicketController {
	
	@Autowired
	private TicketVendor ticketVendorservice;

	@Autowired
	private MovieService movieService;

	@PostMapping(path = "/tickets")
	public @ResponseBody ResponseWrapper<?> loadTickets(@Validated @RequestBody TicketLoadRequest request ) throws TicketingException, MovieNotFoundException {

		
		
		ResponseWrapper<String> response = new ResponseWrapper<>();
		Movie movie = movieService.getMovieById(request.getMovieId());
		/*if (movie == null) {
			throw new TicketingException("Movie not found");
		}*/
		ticketVendorservice.loadTickets(movie, request.getTicketType(), request.getPrice(), request.getCount());
		response.setStatus(Status.SUCCESS);
		response.setResponse("Ticket loaded successfully");
		return response;
		//return "{Load Tickets e Successfull}";
	}
	
	 /*@ExceptionHandler(MethodArgumentNotValidException.class)
     @ResponseStatus(value=HttpStatus.BAD_REQUEST)
     @ResponseBody
     public ResponseWrapper<Error> handleMethodArgumentNotValid( MethodArgumentNotValidException ex){
		BindingResult result = ex.getBindingResult();
		
		StringBuilder builder = new StringBuilder();
		result.getFieldErrors().forEach(err -> {
			builder.append("FieldName - " + err.getField());
			builder.append(",Value Recived - " + err.getRejectedValue());
			builder.append(",Message - " + err.getDefaultMessage());
			
		});
		
		ResponseWrapper<Error> response = new ResponseWrapper<>();
		response.setStatus(Status.ERROR);
		com.mytectra.learning.bookourshow.web.entity.Error error = new Error();
		error.setErrorCode(1112);
		error.setErrorMessage(builder.toString());
		response.setResponse(error);
		return response;	
	 }*/
	
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
}
