package com.compasso.cars.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Car {

	@Id //@GeneratedValue(generator = "uuid")
	private String chassi;
	private String nome;
	private String marca;
	private String cor;
	private BigDecimal valor;
	private int data;
	
	/*public Car()
	{
		//esse construtor só serve pra não jogar nenhma exception na tela do cliente
	}*/
	
	/*public Car (String chassi, String nome, String marca, String cor, BigDecimal valor, int data)
	{
		this.chassi = chassi;
		this.nome = nome;
		this.marca = marca;
		this.cor = cor;
		this.valor = valor;
		this.data = data;
	}*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		return true;
	}
	
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
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}


}
