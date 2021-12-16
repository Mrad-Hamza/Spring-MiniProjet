package tn.spring.spring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.spring.spring.entity.Stock;

public interface IStock {
	List<Stock> retrieveAllStocks();

	List<Stock> retrieveActiveStocks();
	
	List<Stock> retrievePassiveStocks();
	
	List<Stock> orderStocksByQte();
	
	List<Stock> orderStocksByLibelle();
	
	Stock addStock(Stock s);

	@Transactional
	void deleteStock(Long id);

	Stock  removeStock(Stock s);
	
	Stock  activeStock(Stock s);
	
	Stock updateStock(Stock s);
	
	Stock updateRatingStock(Stock s);
	
	Stock updateStatusStock(Stock s);
	
	Stock addImageStock(String urlImage, Long id);

	Stock retrieveStock(Long id);
	
	String retrieveStatusStock();
	
	Stock searchStockByName(String libelle);
	
	List<Stock> searchStockByQte(int qteStock);
	
	List<Stock> getStockByStatus();
	
	List<Stock> searchAdvancedStocks(String mot);
	
	List<?> getnbreStocksbyDate();
	
	List<?> getnbreStocksbystatus();
	
	List<?> getnbreProduitStocks();
}
