package com.mytectra.learning.bookourshow.dao;

import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Booking;

public interface BookingDao {

	int saveBooking(Booking booking);
}
