package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Stock;


public interface IStock {
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock c);

	void deleteStock(Long id);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);
}
