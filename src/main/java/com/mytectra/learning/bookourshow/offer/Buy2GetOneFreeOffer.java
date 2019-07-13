package com.mytectra.learning.bookourshow.offer;

import java.util.List;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Ticket;

public class Buy2GetOneFreeOffer implements Offer {

	public void applyOffer(Booking booking) {
		if(booking == null) {
			throw new IllegalArgumentException();
		}
		List<Ticket> tickets = booking.getTickets();
		int count = 0;
		for (Ticket ticket : tickets) {
			if (count == 2) {
				ticket.setDiscounted(true);
				count = 0;
				// call booking.appendOffersApplied(Str)
				booking.appendOffersApplied("Ticket Discount Applied  - " + ticket.getId());
			} else {
				count++;
			}
		}
	}

}
