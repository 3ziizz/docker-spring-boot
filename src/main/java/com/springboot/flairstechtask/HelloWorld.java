package com.springboot.flairstechtask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping(value= "/hello", method = RequestMethod.GET)
	public String onHttpGETInit(HttpServletRequest httpServletRequest, HttpServletResponse response) {

		System.out.println("request : " + httpServletRequest);
		return "HI";
	}
}
