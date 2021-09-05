package com.compasso.cars.controller.dto;

import java.math.BigDecimal;

import java.util.List;
import java.util.stream.Collectors;

import com.compasso.cars.model.Car;


public class CarDto {
	
	private String chassi;
	private String nome;
	private String marca;
	private String cor;
	private BigDecimal valor;
	private int anoFabricacao;
	
	public CarDto(Car car)
	{
		this.chassi = car.getChassi();
		this.nome = car.getNome();
		this.marca = car.getMarca();
		this.cor = car.getCor();
		this.valor = car.getValor();
		this.anoFabricacao = car.getAnoFabricacao();
	}
	
	

	public String getChassi() {
		return chassi;
	}



	public String getNome() {
		return nome;
	}



	public String getMarca() {
		return marca;
	}



	public String getCor() {
		return cor;
	}



	public BigDecimal getValor() {
		return valor;
	}



	public int getAnoFabricacao() {
		return anoFabricacao;
	}



	public static List<CarDto> converter(List<Car> cars) {
		// TODO Auto-generated method stub
		return cars.stream().map(CarDto::new).collect(Collectors.toList());
	}
}
