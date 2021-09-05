package com.compasso.cars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.cars.model.Car;

public interface CarRepository extends JpaRepository<Car, String>{

	List<Car> findByNome(String nomeCarro);

}
