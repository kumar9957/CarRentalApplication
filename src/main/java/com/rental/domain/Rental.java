package com.rental.domain;

public class Rental {

	private Car Car;

	public Car getCar() {
		return Car;
	}

	public void setCar(Car car) {
		Car = car;
	}

	@Override
	public String toString() {
		return "Rental [Car=" + Car + "]";
	}

}
