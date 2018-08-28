package com.rental.utils;

import java.io.File;
import java.util.List;

import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rental.domain.Rental;

public class Commons {

	public List<Rental> constructJson() {
		List<Rental> rental = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = ResourceUtils.getFile("classpath:test.json");
			rental = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Rental.class));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return rental;
	}

}
