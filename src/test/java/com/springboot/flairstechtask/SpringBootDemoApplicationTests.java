package com.springboot.flairstechtask;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = FlairstechTaskApplication.class)
public class SpringBootDemoApplicationTests {
	@LocalServerPort
	int randomServerPort;

	@Test
	public void testInvaildCountryCode() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		try {

			final String baseUrl = "http://localhost:" + randomServerPort + "/WRONG_CODE";
			URI uri = new URI(baseUrl);

			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		} catch (HttpServerErrorException ex) {
			Assert.assertEquals(500, ex.getRawStatusCode());
			assertEquals(true, ex.getResponseBodyAsString().contains("INVALID_COUNTRY_CODE"));
		}
	}

	@Test
	public void testDbConnectionError() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		try {

			final String baseUrl = "http://localhost:" + randomServerPort + "/BHR";
			URI uri = new URI(baseUrl);

			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		} catch (HttpServerErrorException ex) {
			Assert.assertEquals(500, ex.getRawStatusCode());
			assertEquals(true, ex.getResponseBodyAsString().contains("INTERNAL_ERROR"));
		}
	}
	
}