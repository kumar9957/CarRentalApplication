package com.rental.domain;

public class Perdayrent {
	private String Price;

	private String Discount;

	public String getPrice() {
		return Price;
	}

	public void setPrice(String Price) {
		this.Price = Price;
	}

	public String getDiscount() {
		return Discount;
	}

	public void setDiscount(String Discount) {
		this.Discount = Discount;
	}

	@Override
	public String toString() {
		return "ClassPojo [Price = " + Price + ", Discount = " + Discount + "]";
	}
}