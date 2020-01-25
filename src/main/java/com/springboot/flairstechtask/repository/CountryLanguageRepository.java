package com.springboot.flairstechtask.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.flairstechtask.entity.Countrylanguage;

public interface CountryLanguageRepository extends CrudRepository<Countrylanguage, String> {

	List<Countrylanguage> findAll();

	Countrylanguage findByCountryCode(String countryCode);
}
