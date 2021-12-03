package tn.spring.spring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.spring.spring.entity.Stock;

public interface IStock {
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	@Transactional
	void deleteStock(Long id);

	Stock updateStock(Stock s);

	Stock retrieveStock(Long id);
}
