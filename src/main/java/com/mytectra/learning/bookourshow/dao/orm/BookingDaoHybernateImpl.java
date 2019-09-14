package com.mytectra.learning.bookourshow.dao.orm;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.dao.BookingDao;
import com.mytectra.learning.bookourshow.entity.Booking;

@Component
@Primary
public class BookingDaoHybernateImpl implements BookingDao {
	
	@Autowired
	private EntityManager manager;

	@Override
	public int saveBooking(Booking booking) {
			manager.persist(booking);
			return 1;
	}

}
