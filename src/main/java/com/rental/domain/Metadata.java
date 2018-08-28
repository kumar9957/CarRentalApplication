package com.rental.domain;

public class Metadata {
	
	private String Notes;

	private String Color;

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String Notes) {
		this.Notes = Notes;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String Color) {
		this.Color = Color;
	}

	@Override
	public String toString() {
		return "ClassPojo [Notes = " + Notes + ", Color = " + Color + "]";
	}
}