package com.mytectra.learning.bookourshow.offer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mytectra.learning.bookourshow.entity.Booking;
import com.mytectra.learning.bookourshow.entity.Ticket;
@Component
public class Buy2GetOneFreeOffer implements Offer {

	@Override
	public void applyOffer(Booking booking) {
		List<Ticket> tickets = booking.getTickets();
		int count = 0;
		for(Ticket ticket : tickets) {
			count++;
			if(count == 2) {
				ticket.setDiscounted(true);
				count = 0;
				//call booking.appendOffersApplied(Str)
				booking.appendOffersApplied("Ticket Discount Applied  - " +ticket.getId() );
			}
		}
	}

}
