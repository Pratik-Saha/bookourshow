package com.mytectra.learning.bookourshow.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Booking_id")
	private int id;
	
	//private User user;
	
	@OneToMany(mappedBy = "booking" , cascade = CascadeType.MERGE)
	private List<Ticket> tickets;

	@Column(name = "tax")
	private double tax;
	
	@Column(name = "discount")
	private double discount;
	
	@Column(name = "Discounted_Price")
	private double discountedPrice;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "Grand_total")
	private double grandTotal;
	
	@Transient
	private List<String> offersApplied = new ArrayList<String>();
	
	@Transient
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
	
	

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getDiscountedPrice() {
		return discountedPrice;
	}
	
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public double getGrandTotal() {
		return grandTotal;
	}
}

