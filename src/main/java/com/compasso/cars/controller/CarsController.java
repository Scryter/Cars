package com.compasso.cars.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.cars.controller.dto.CarDto;
import com.compasso.cars.model.Car;
import com.compasso.cars.repository.CarRepository;


@RestController
@RequestMapping("/api")
public class CarsController 
{
	@Autowired
	private CarRepository carRepository;

	@RequestMapping ("/cars")
	public List<CarDto> lista(String nomeCarro)
	{
		List<Car> cars;
		System.out.println("O cliente fez uma requisição como filtro: "+nomeCarro);
		if (nomeCarro == null)
			cars = carRepository.findAll();
		else	
			cars = carRepository.findByNome(nomeCarro);		
		return CarDto.converter(cars);
	}
}
