package com.rental.domain;

public class RentCarObj {

	private Double price;
	private Car car;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "RentCompare [price=" + price + ", car=" + car + "]";
	}

}
