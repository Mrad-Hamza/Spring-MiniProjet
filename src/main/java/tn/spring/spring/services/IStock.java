package tn.spring.spring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.spring.spring.entity.Stock;

public interface IStock {
	List<Stock> retrieveAllStocks();

	List<Stock> retrieveActiveStocks();
	
	List<Stock> retrievePassiveStocks();
	
	Stock addStock(Stock s);

	@Transactional
	void deleteStock(Long id);

	Stock updateStock(Stock s);
	
	Stock updateStatusStock(Stock s);

	Stock retrieveStock(Long id);
	
	String retrieveStatusStock();
	
	Stock searchStockByName(String libelle);
	
	List<Stock> searchStockByQte(int qteStock);
	
	List<Stock> getStockByStatus();
}
