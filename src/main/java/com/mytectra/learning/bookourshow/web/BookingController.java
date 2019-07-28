package com.mytectra.learning.bookourshow.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mytectra.learning.bookourshow.core.BookOurShow;
import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.service.MovieService;
import com.mytectra.learning.bookourshow.tickets.TicketingExecption;
import com.mytectra.learning.bookourshow.web.entity.BookingRequest;

@RestController
@RequestMapping(path = "/bos")
public class BookingController {
	
	@Autowired  
	BookOurShow bookOurShowService;
	
	@Autowired
	MovieService movieService;
	
	@PostMapping(path = "/booking")
	public  @ResponseBody Booking booktickets(@RequestBody BookingRequest request) throws TicketingExecption 
	{
		Movie movie = movieService.getMovieById(request.getMovieId());
		if(movie == null)
		{
			throw new TicketingExecption("Movie not found");
		}	
		Booking booking =	bookOurShowService.bookTickets(movie, request.getTicketType(), request.getCount());
		return booking;
	}
	  
	  
	
	
	
	

}
