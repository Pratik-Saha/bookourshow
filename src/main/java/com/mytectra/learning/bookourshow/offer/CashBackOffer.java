
  package com.mytectra.learning.bookourshow.offer;
  
  import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.mytectra.learning.bookourshow.entity.Booking; 
  import  com.mytectra.learning.bookourshow.entity.Ticket;
  
  
  public class CashBackOffer implements Offer {
	  

  @Value("${ten.ticktes.discount}")	  
  private double discount;
	  
  
  public void setDiscount(double discount) {
	this.discount = discount;
}
  
  public void applyOffer(Booking booking) 
  {  
	  
	  List<Ticket> tickets = booking.getTickets(); 
	  int count = tickets.size();
		if (count >= 5 && count <= 10) {
			booking.appendOffersApplied("You will get flash cash back of Rs. 150");
		}

		else if (count > 10) {
			// "%f Tax applied = %f ",tax , taxedAm
			//TODO fix generic message
			booking.appendOffersApplied(" You will get 20% discount");
			booking.setDiscount(discount);
		}
  }
}
  
 
 