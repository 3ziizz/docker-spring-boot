package com.springboot.flairstechtask;

import java.sql.SQLDataException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.flairstechtask.repository.CityRepository;
import com.springboot.flairstechtask.repository.CountryLanguageRepository;
import com.springboot.flairstechtask.repository.CountryRepository;

@RestController
public class HelloWorld {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CountryLanguageRepository countryLanguageRepository;

	@RequestMapping(value = "**", method = RequestMethod.GET)
	public HashMap<String, Object> onHttpGETInit(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("@@@@@@@@@@@@@@@request : " + request.getRequestURI());
		System.out.println("@@@@@@@@@@@@@@@request : " + request.getRequestURI().substring(1));
		String countryCode = request.getRequestURI().substring(1);

		HashMap<String, Object> map = new HashMap<>();

		try {
			System.out.println(
					"-----------------countryRepository-------------" + countryRepository.findByCode(countryCode));
			System.out.println("-----------countryLanguageRepository-------------------"
					+ countryLanguageRepository.findByCountryCode(countryCode));

			map.put("name", countryRepository.findByCode(countryCode).getName());
			map.put("continent", countryRepository.findByCode(countryCode).getContinent());
			map.put("population", countryRepository.findByCode(countryCode).getPopulation());
			map.put("life_expectancy", countryRepository.findByCode(countryCode).getLifeExpectancy());
			map.put("country_language", "bb");

		} catch (Exception e) {
			System.out.println("Please check the countryCode");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			map.put("name", null);
			map.put("continent", null);
			map.put("population", null);
			map.put("life_expectancy", null);
			map.put("country_language", null);
		}
		return map;
	}
}
