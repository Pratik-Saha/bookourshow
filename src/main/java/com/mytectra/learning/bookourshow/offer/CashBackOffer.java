
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
  /**
   * if tickets are between 5 to 10 then will get cash back of 150 , if it is more than 10 then discount is applied
   * 
   * Booking
   * 5 to 10 - if will add offer (String) (1) ? "You will get flash cash back of Rs. 150"
   * > 10 - discount will set - booking, will add offer (String ) (1)
   * else nothing no change in the booking
   * null (Null pointer Ex ) - Bug
   * 
   */
  public void applyOffer(Booking booking) 
  {  
	  
	  List<Ticket> tickets = booking.getTickets(); 
	  int count = tickets.size();
		if (count >= 5 && count <= 10) {
			booking.appendOffersApplied("You will get flash cash back of Rs. 150");
		}

		else if (count > 10) {
			// "%f Tax applied = %f ",tax , taxedAmt
			String str = String.format("You will get %.1f%% discount" , discount);
			booking.appendOffersApplied(str);
			booking.setDiscount(discount);
		}
  
  }
}
  
 
 