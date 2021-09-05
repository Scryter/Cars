package com.compasso.cars.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.compasso.cars.model.Car;
import com.compasso.cars.repository.CarRepository;

public class CarForm {
	@NotNull @NotEmpty @Length(min = 18, max = 36)
	private String chassi;
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String marca;
	@NotNull @NotEmpty
	private String cor;
	@NotNull 
	private BigDecimal valor;
	@NotNull
	private int anoFabricacao;
	

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Car converter() {
		// TODO Auto-generated method stub
		//Car car = repository.findByNome(nome)
		return new Car(chassi, nome, marca, cor, valor, anoFabricacao);
	}
	
	
	
	
	

}
