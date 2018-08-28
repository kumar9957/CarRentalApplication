package com.rental.utils;

import java.util.Comparator;

import com.rental.domain.RentCarObj;

public class RentalCompare implements Comparator<RentCarObj> {

	@Override
	public int compare(RentCarObj rentCarObj1, RentCarObj rentCarObj2) {
		return rentCarObj1.getPrice().compareTo(rentCarObj2.getPrice());
	}

}
