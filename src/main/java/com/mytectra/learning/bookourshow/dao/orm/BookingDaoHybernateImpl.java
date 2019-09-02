package com.mytectra.learning.bookourshow.dao.orm;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.mytectra.learning.bookourshow.dao.BookingDao;
import com.mytectra.learning.bookourshow.entity.Booking;

public class BookingDaoHybernateImpl implements BookingDao {
	
	@Autowired
	private EntityManager manager;

	@Override
	public int saveBooking(Booking booking) {
			return 0;
	}

}
