package com.rental.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.domain.Car;
import com.rental.domain.RentCarObj;
import com.rental.domain.Rental;
import com.rental.utils.Commons;
import com.rental.utils.RentalCompare;

@RestController
@RequestMapping("/V1")
public class TestController {

	/**
	 * @return list of cars which are received from json response
	 */
	@RequestMapping("/get")
	public List<Rental> getAllCarData() {
		Commons commons = new Commons();
		List<Rental> rental = commons.constructJson();
		return rental;
	}

	@RequestMapping("/getAllBlueTeslasCarDetails")
	public List<Car> getAllBlueTeslasCarDetails() {
		List<Car> carList = null;
		try {
			carList = new ArrayList<Car>();
			Commons commons = new Commons();
			List<Rental> rentalList = commons.constructJson();
			for (Rental rental : rentalList) {
				Car car = rental.getCar();
				if (car.getMake().equalsIgnoreCase("Blue Teslas")) {
					carList.add(car);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return carList;
	}

	@RequestMapping("/getLowestFareCarsPerDayPrice")
	public RentCarObj getLowestFareCarsPerDayPrice() {
		RentCarObj rentCarObj = null;
		try {
			Commons commons = new Commons();
			List<Rental> rentalList = commons.constructJson();
			List<RentCarObj> rentCarObjList = new ArrayList<RentCarObj>();
			for (Rental rental : rentalList) {
				RentCarObj rentCarObj1 = new RentCarObj();
				rentCarObj1.setPrice(Double.parseDouble(rental.getCar().getPerdayrent().getPrice()));
				rentCarObj1.setCar(rental.getCar());
				rentCarObjList.add(rentCarObj1);
			}
			rentCarObj = Collections.min(rentCarObjList, new RentalCompare());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return rentCarObj;
	}

	@RequestMapping("/getLowestFareCarsPerDayPriceWithDiscount")
	public RentCarObj getLowestFareCarsPerDayPriceWithDiscount() {
		RentCarObj rentCarObj = null;
		try {
			Commons commons = new Commons();
			List<Rental> rentalList = commons.constructJson();
			List<RentCarObj> rentCarObjList = new ArrayList<RentCarObj>();
			for (Rental rental : rentalList) {
				RentCarObj rentCarObj1 = new RentCarObj();
				rentCarObj1.setPrice(Double.parseDouble(rental.getCar().getPerdayrent().getPrice())
						- Double.parseDouble(rental.getCar().getPerdayrent().getDiscount()));
				rentCarObj1.setCar(rental.getCar());
				rentCarObjList.add(rentCarObj1);
			}
			rentCarObj = Collections.min(rentCarObjList, new RentalCompare());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return rentCarObj;
	}

	@RequestMapping("/getHighestRevnueGenerateCar")
	public RentCarObj getHighestRevnueGenerateCar() {
		RentCarObj rentCarObj = null;
		try {
			Commons commons = new Commons();
			List<Rental> rentalList = commons.constructJson();
			List<RentCarObj> rentCarObjList = new ArrayList<RentCarObj>();
			for (Rental rental : rentalList) {
				RentCarObj rentCarObj1 = new RentCarObj();
				rentCarObj1.setPrice(Double.parseDouble(rental.getCar().getMetrics().getYoymaintenancecost())
						+ Double.parseDouble(rental.getCar().getMetrics().getDepreciation()));
				rentCarObj1.setCar(rental.getCar());
				rentCarObjList.add(rentCarObj1);
			}
			rentCarObj = Collections.max(rentCarObjList, new RentalCompare());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return rentCarObj;
	}

}
