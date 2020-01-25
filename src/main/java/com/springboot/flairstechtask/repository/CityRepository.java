package com.springboot.flairstechtask.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.flairstechtask.entity.City;
@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

	List<City> findAll();

	City findById (int id);
}
