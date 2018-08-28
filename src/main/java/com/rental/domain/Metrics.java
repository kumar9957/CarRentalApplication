package com.rental.domain;

public class Metrics {
	
	private String depreciation;

	private String yoymaintenancecost;

	private Rentalcount rentalcount;

	public String getDepreciation() {
		return depreciation;
	}

	public void setDepreciation(String depreciation) {
		this.depreciation = depreciation;
	}

	public String getYoymaintenancecost() {
		return yoymaintenancecost;
	}

	public void setYoymaintenancecost(String yoymaintenancecost) {
		this.yoymaintenancecost = yoymaintenancecost;
	}

	public Rentalcount getRentalcount() {
		return rentalcount;
	}

	public void setRentalcount(Rentalcount rentalcount) {
		this.rentalcount = rentalcount;
	}

	@Override
	public String toString() {
		return "ClassPojo [depreciation = " + depreciation + ", yoymaintenancecost = " + yoymaintenancecost
				+ ", rentalcount = " + rentalcount + "]";
	}
}