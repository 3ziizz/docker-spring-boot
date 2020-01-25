package com.springboot.flairstechtask;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.flairstechtask.repository.CountryLanguageRepository;
import com.springboot.flairstechtask.repository.CountryRepository;
import com.sun.org.apache.regexp.internal.RE;

@RestController
public class HelloWorld {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CountryLanguageRepository countryLanguageRepository;

	@RequestMapping(value = "**", method = RequestMethod.GET)
	public LinkedHashMap<String, Object> onHttpGETInit(HttpServletRequest request, HttpServletResponse response) {

		String countryCode = request.getRequestURI().substring(1);

		LinkedHashMap<String, Object> map = new LinkedHashMap<>();

		try {
			if (!countryRepository.findByCode(countryCode).equals(null)) {

				map.put("name", countryRepository.findByCode(countryCode).getName());
				map.put("continent", countryRepository.findByCode(countryCode).getContinent());
				map.put("population", countryRepository.findByCode(countryCode).getPopulation());
				map.put("life_expectancy", countryRepository.findByCode(countryCode).getLifeExpectancy());
				map.put("country_language",
						countryLanguageRepository.findByCountryCodeOrderByPercentageDesc(countryCode).get(0)
								.getCountrylanguagePK().getLanguage());
			} else {
				map.put("massage", ResponseMessage.INVALID_COUNTRY_CODE);
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} catch (NullPointerException e) {

			map.put("massage", ResponseMessage.INVALID_COUNTRY_CODE);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		} catch (Exception e) {

			System.out.println("Please check the countryCode");
			System.out.println("Exception : " + e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			map.put("massage", ResponseMessage.INTERNAL_ERROR);

		}
		return map;
	}
}
