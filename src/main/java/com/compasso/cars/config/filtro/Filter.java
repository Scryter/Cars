package com.compasso.cars.config.filtro;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.compasso.cars.model.Car;
import com.compasso.cars.repository.CarRepository;



public class Filter {
	
	private ByFilter filtro;
	private ByOrder ordem;	
	private CarRepository carRepository;
	private String termoBuscado;
	
    public Filter(String filtro, String ordem, String busca, CarRepository carRepository)
    {

        this.carRepository = carRepository;
        
        if(filtro != null && busca != null)
        {
            this.filtro = ByFilter.valueOf(filtro.toUpperCase());
            this.termoBuscado = busca;
        } 
        else
        	this.filtro = ByFilter.Desativado;

        try 
        {
            if(ordem != null)
                this.ordem = ByOrder.valueOf(ordem.toUpperCase());
            else
            	this.ordem= ByOrder.Desativado;
        } 
        catch (IllegalArgumentException exception)
        {
        	this.filtro= ByFilter.Desativado;
            this.ordem= ByOrder.Desativado;   
        }
    }
    
    private List<Car> MetodoBusca()
    {
    	List<Car> carrosFiltrados;
    	
    	switch (filtro)
    	{
    	case Marca:
    		carrosFiltrados = carRepository.findByMarca(termoBuscado);
    		break;
    	case Cor:
    		carrosFiltrados = carRepository.findByCor(termoBuscado);
    		break;
    	case Nome:
    		carrosFiltrados = carRepository.findByNome(termoBuscado);
    		break;
    	default:
    		carrosFiltrados = carRepository.findAll();
    		break;
    	}
    	return carrosFiltrados;
    }
    
    public List<Car> getResults()
    {
    	return this.OrderList(this.MetodoBusca());
    }
    
    private List<Car> OrderList(List<Car> filteredCarList){
        switch (ordem) 
        {
            case Desativado:
                break;
            case AnoFabricacao:
            	Collections.sort(filteredCarList, (car, otherCar) -> 
                {
                	if (car.getAnoFabricacao() > otherCar.getAnoFabricacao())
                		return -1;
                	if (car.getAnoFabricacao() < otherCar.getAnoFabricacao())
                		return 1;
                	return 0;
                });
                break;
            case Nome:
                Collections.sort(filteredCarList, Comparator.comparing(Car::getNome));
                break;
            case Valor:
                Collections.sort(filteredCarList, Comparator.comparing(Car::getValor));
                break;
        }
        return filteredCarList;
    }

}
