package com.springboot.flairstechtask.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.flairstechtask.entity.Country;
@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

	List<Country> findAll();

	Country findByCode(String code);
}
