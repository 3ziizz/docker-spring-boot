package com.springboot.flairstechtask.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.flairstechtask.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {

	List<Country> findAll();

	Country findByCode(String code);
}
