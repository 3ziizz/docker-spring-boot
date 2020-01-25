package com.springboot.flairstechtask.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.flairstechtask.entity.City;

public interface CityRepository extends CrudRepository<City, Integer> {

	List<City> findAll();

	City findById(int id);
}
