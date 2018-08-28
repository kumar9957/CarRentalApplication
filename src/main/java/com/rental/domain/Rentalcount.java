package com.rental.domain;

public class Rentalcount {
	
	private String yeartodate;

	private String lastweek;

	public String getYeartodate() {
		return yeartodate;
	}

	public void setYeartodate(String yeartodate) {
		this.yeartodate = yeartodate;
	}

	public String getLastweek() {
		return lastweek;
	}

	public void setLastweek(String lastweek) {
		this.lastweek = lastweek;
	}

	@Override
	public String toString() {
		return "ClassPojo [yeartodate = " + yeartodate + ", lastweek = " + lastweek + "]";
	}
}