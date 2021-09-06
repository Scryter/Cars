package com.compasso.cars.controller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.cars.config.filtro.Filter;
import com.compasso.cars.controller.dto.CarDto;
import com.compasso.cars.controller.form.CarForm;
import com.compasso.cars.model.Car;
import com.compasso.cars.repository.CarRepository;



@RestController
@RequestMapping("/api/cars")
public class CarsController 
{
	@Autowired
	private CarRepository carRepository;

	/*@GetMapping//@RequestMapping ("/cars")
	public List<CarDto> lista(String nomeCarro)
	{
		List<Car> cars;
		System.out.println("O cliente fez uma requisição como filtro: "+nomeCarro);
		if (nomeCarro == null)
			cars = carRepository.findAll();
		else	
			cars = carRepository.findByNome(nomeCarro);		
		return CarDto.converter(cars);
	}*/
	
	//=====================================
    @GetMapping
    public ResponseEntity<?> completeFilter(
            @RequestParam(name="filtro", required = false) String filtro,
            @RequestParam(name="ordem", required = false) String ordem,
            @RequestParam(name="valor", required = false) String valor
    )
    {
        List<Car> cars = new Filter(filtro, ordem, valor, carRepository).getResults();

        if(cars.size() == 0) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cars);
    }
	
	
	//=========================================
	@PostMapping
	public ResponseEntity <CarDto> cadastrar(@RequestBody @Valid CarForm form, UriComponentsBuilder uriBuilder)
	{
		Car car = form.converter();
		carRepository.save(car);
		
		
		URI uri = uriBuilder.path("/api/cars/{id}").buildAndExpand(car.getChassi()).toUri();
		return ResponseEntity.created(uri).body(new CarDto(car));
	}
}
