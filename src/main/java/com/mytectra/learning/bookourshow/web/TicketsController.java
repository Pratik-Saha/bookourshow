package com.mytectra.learning.bookourshow.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mytectra.learning.bookourshow.entity.Movie;
import com.mytectra.learning.bookourshow.entity.Ticket;
import com.mytectra.learning.bookourshow.entity.Ticket.TicketType;
import com.mytectra.learning.bookourshow.service.MovieService;
import com.mytectra.learning.bookourshow.tickets.TicketVendor;
import com.mytectra.learning.bookourshow.tickets.TicketingExecption;
import com.mytectra.learning.bookourshow.web.entity.TicketLoadRequest;

@RestController
@RequestMapping(path = "/bos")
public class TicketsController {

	@Autowired
	private TicketVendor ticketVendorservice;

	@Autowired
	private MovieService movieService;

	@PostMapping(path = "/tickets")
	public @ResponseBody String loadTickets(@RequestBody TicketLoadRequest request) throws TicketingExecption {

		Movie movie = movieService.getMovieById(request.getMovieId());
		if (movie == null) {
			throw new TicketingExecption("Movie not found");
		}
		ticketVendorservice.loadTickets(movie, request.getTicketType(), request.getPrice(), request.getCount());
		return "{Load Tickets : Successfull}";
	}

		
		
	}

