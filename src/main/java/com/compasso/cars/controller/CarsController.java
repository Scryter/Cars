package com.compasso.cars.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.cars.controller.dto.CarDto;
import com.compasso.cars.model.Car;


@RestController
@RequestMapping("/api")
public class CarsController 
{

	//esse deu certo 100%
	/*@RequestMapping ("/cars")
	public List<CarDto> lista()
	{
		Car car1 = new Car("9BBNSZPPA288003333", "New Fiesta", "ford", "branco", new BigDecimal("28.100"), 2015);
		
		return CarDto.converter(Arrays.asList(car1, car1, car1));
	}*/

	@RequestMapping ("/cars")
	public List<CarDto> lista(String nomeCarro)
	{
		Car car1 = new Car("9BBNSZPPA288003333", "New Fiesta", "ford", "branco", new BigDecimal("28.100"), 2015);
		
		return CarDto.converter(Arrays.asList(car1, car1, car1));
	}


	
/*	public List<Car> lista(String nomeCarro) {
	if (nomeCarro == null) {
		List<Car> cars = CarRepository.findAll();
		return Car.converter(cars);
	} else {
		List<Car> cars = carRepository.findByCursoNome(nomeCarro);
		return Car.converter(cars);
	}*/
}
