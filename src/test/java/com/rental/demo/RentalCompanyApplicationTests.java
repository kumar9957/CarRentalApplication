package com.rental.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rental.domain.Car;
import com.rental.domain.RentCarObj;
import com.rental.domain.Rental;
import com.rental.utils.RentalCompare;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalCompanyApplicationTests {

	/**
	 * Unit test case for retrieving all rental cars from json response
	 */
	@Test
	public void getAll() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = ResourceUtils.getFile("classpath:test.json");
			List<Rental> rental = mapper.readValue(file,
					mapper.getTypeFactory().constructCollectionType(List.class, Rental.class));
			System.out.println(rental);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * Printing all the blue teslas car details from response
	 */
	@Test
	public void getAllBlueTeslasCarDetails() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = ResourceUtils.getFile("classpath:test.json");
			List<Rental> rentalList = mapper.readValue(file,
					mapper.getTypeFactory().constructCollectionType(List.class, Rental.class));
			for (Rental rental : rentalList) {
				Car car = rental.getCar();
				if (car.getMake().equalsIgnoreCase("Blue Teslas")) {
					System.out.println("Blue Teslas details are : ");
					System.out.println(car);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * Lowest per day rental cost for price only 
	 */
	@Test
	public void getLowestFareCarsPerDayPrice() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = ResourceUtils.getFile("classpath:test.json");
			List<Rental> rentalList = mapper.readValue(file,
					mapper.getTypeFactory().constructCollectionType(List.class, Rental.class));
			List<RentCarObj> rentCarObjList = new ArrayList<RentCarObj>();
			for (Rental rental : rentalList) {
				RentCarObj rentCarObj = new RentCarObj();
				rentCarObj.setPrice(Double.parseDouble(rental.getCar().getPerdayrent().getPrice()));
				rentCarObj.setCar(rental.getCar());
				rentCarObjList.add(rentCarObj);
			}
			RentCarObj rentCarObjMin = Collections.min(rentCarObjList, new RentalCompare());
			System.out.println("Final Value is :: "+ rentCarObjMin);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
	/**
	 *  Lowest per day rental cost for price with discount
	 */
	@Test
	public void getLowestFareCarsPerDayPriceWithDiscount() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = ResourceUtils.getFile("classpath:test.json");
			List<Rental> rentalList = mapper.readValue(file,
					mapper.getTypeFactory().constructCollectionType(List.class, Rental.class));
			List<RentCarObj> rentCarObjList = new ArrayList<RentCarObj>();
			for (Rental rental : rentalList) {
				RentCarObj rentCarObj = new RentCarObj();
				rentCarObj.setPrice(Double.parseDouble(rental.getCar().getPerdayrent().getPrice()) - Double.parseDouble(rental.getCar().getPerdayrent().getDiscount()));
				rentCarObj.setCar(rental.getCar());
				rentCarObjList.add(rentCarObj);
			}
			RentCarObj rentCarObjMin = Collections.min(rentCarObjList, new RentalCompare());
			System.out.println("Final Value is :: "+ rentCarObjMin);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
	/**
	 *  Highest Revenue generate car maintenance cost + depreciation 
	 */
	@Test
	public void getHighestRevnueGenerateCar() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = ResourceUtils.getFile("classpath:test.json");
			List<Rental> rentalList = mapper.readValue(file,
					mapper.getTypeFactory().constructCollectionType(List.class, Rental.class));
			List<RentCarObj> rentCarObjList = new ArrayList<RentCarObj>();
			for (Rental rental : rentalList) {
				RentCarObj rentCarObj = new RentCarObj();
				rentCarObj.setPrice(Double.parseDouble(rental.getCar().getMetrics().getYoymaintenancecost()) + Double.parseDouble(rental.getCar().getMetrics().getDepreciation()));
				rentCarObj.setCar(rental.getCar());
				rentCarObjList.add(rentCarObj);
			}
			RentCarObj rentCarObjMin = Collections.max(rentCarObjList, new RentalCompare());
			System.out.println("Final Value is :: "+ rentCarObjMin);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
