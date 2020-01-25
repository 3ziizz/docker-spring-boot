package com.springboot.flairstechtask.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.flairstechtask.entity.Countrylanguage;

@Repository
public interface CountryLanguageRepository extends CrudRepository<Countrylanguage, String> {

	List<Countrylanguage> findByCountryCodeOrderByPercentageDesc(String countryCode);

}
