package com.springboot.flairstechtask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.flairstechtask.repository.CityRepository;

@RestController
public class HelloWorld {

	@Autowired
	private CityRepository cityRepository;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String onHttpGETInit(HttpServletRequest httpServletRequest, HttpServletResponse response) {

		// fetch all customers
		System.out.println("City found with findAll():");
		System.out.println("-------------------------------");
		System.out.println(cityRepository.findAll());
		//		System.out.println(cityRepository.findById(1));

		System.out.println("request : " + httpServletRequest);
		return "HI";
	}
}
