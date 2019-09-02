package com.mytectra.learning.bookourshow.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.dao.BookingDao;
import com.mytectra.learning.bookourshow.entity.Booking;

@Component
public class BookingDaoJDBCImpl implements BookingDao {
	
	@Autowired
	private JdbcTemplate template;
	
	private final String INSERT_BOOKING = "insert into Booking (bookingId,ticketType,ticketPrice,noOfTickets,movieId,movieName,tax,discount,discountedPrice,price,grandTotal) values(?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public int saveBooking(Booking booking) {
		
		return template.update(INSERT_BOOKING, new Object[] {booking.getId(),booking.getTickets().get(0).getTicketType().name(),
				booking.getTickets().get(0).getPrice(),booking.getTickets().size(),booking.getTickets().get(0).getMovie().getId(),
				booking.getTickets().get(0).getMovie().getMovieName(),booking.getTax(),booking.getDiscount(),booking.getDiscountedPrice(),
				booking.getPrice(),booking.getGrandTotal()});
	}

}
