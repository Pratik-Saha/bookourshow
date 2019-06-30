package com.mytectra.learning.bookourshow.entity;

import java.util.ArrayList;
import java.util.List;

public class Booking {
	
	private int id;
	
	//private User user;
	
	private List<Ticket> tickets;
	
	private double tax;

	private double price;
	
	private List<String> offersApplied = new ArrayList<String>();
	
	private List<String> pricingInfo = new ArrayList<String>();

	public List<String> getPricingInfo() {
		return pricingInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getOffersApplied() {
		return offersApplied;
	}

	/**
	 * It takes string (offerInfo) and appends (add to list) it to the list (offers Applies)
	 * @param offerInfo
	 */
	public void appendOffersApplied(String offerInfo) {
		offersApplied.add(offerInfo);
		
	}
	public void appendPricingInfo(String pricingInfo) {
		this.pricingInfo.add(pricingInfo);
	}
	
	public double getTotalPrice() {
		return tax + price;
	}
	
	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

}
