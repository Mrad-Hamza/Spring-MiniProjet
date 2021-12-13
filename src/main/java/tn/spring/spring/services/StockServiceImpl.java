package tn.spring.spring.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.Produit;
import tn.spring.spring.entity.Stock;
import tn.spring.spring.repository.StockRepository;

@Service
public class StockServiceImpl implements IStock{
	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> allStocks = stockRepository.findAll();
		return allStocks;
	}

	@Override
	public List<Stock> retrieveActiveStocks() {
		List<Stock> allStocks = stockRepository.getActiveStocks();
		return allStocks;
	}

	@Override
	public List<Stock> retrievePassiveStocks() {
		List<Stock> allStocks = stockRepository.getPassiveStocks();
		return allStocks;
	}

	@Override
	public Stock addStock(Stock s) {
		s.setState(true);
		Date date = new Date();
		s.setCreatedDate(date);
		s.setUrlImage("../../../../assets/img/NS.PNG");
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteByIdStock(id);

	}

	@Override
	public Stock removeStock(Stock s) {
		s.setState(false);
		Date date = new Date();
		s.setUpdatedDate(date);
		String msg="";
		System.out.println(msg="quantité " + s.getQteStock()+"< "+ s.getQteMin());
		return stockRepository.save(s);

	}
	
	@Override
	public Stock activeStock(Stock s) {
		s.setState(true);
		Date date = new Date();
		s.setUpdatedDate(date);
		String msg="";
		System.out.println(msg="quantité " + s.getQteStock()+"< "+ s.getQteMin());
		return stockRepository.save(s);

	}

	@Override
	public Stock updateStock(Stock s) {
		Date date = new Date();
		s.setUpdatedDate(date);
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		return stockRepository.findByIdStock(id);
	}

	@Override
	public Stock updateStatusStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public String retrieveStatusStock() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String FinaleMsg ="";
		String newLine = System.getProperties().getProperty("Line.separator");
		List<Stock> stocksEnRouge = stockRepository.getStockByStatus();
		for(int i =0;i<stocksEnRouge.size();i++) {
			FinaleMsg = newLine + FinaleMsg+msgDate+newLine+" : le produit "+stocksEnRouge.get(i).getLibelleStock()+ " a un stock de "
					+stocksEnRouge.get(i).getQteStock()+ "inférieure à la quantité minimale à ne pas dépasser de " + stocksEnRouge.get(i).getQteMin()
					+newLine;
		}
		return FinaleMsg;
	}

	@Override
	public Stock searchStockByName(String libelle) {
		// TODO Auto-generated method stub
		return stockRepository.searchStockByName(libelle);
	}

	@Override
	public List<Stock> searchStockByQte(int qteStock) {
		List<Stock> StocksByQte = stockRepository.searchStockByQte(qteStock);
		return StocksByQte;
	}

	@Override
	public List<Stock> getStockByStatus() {
		List<Stock> stockByStatus= stockRepository.getStockByStatus();
		String msg="";
		for(Stock stock : stockByStatus) {
			System.out.println(msg="quantité " + stock.getQteStock()+"< "+ stock.getQteMin());
		}
		return stockByStatus;
	}

	@Override
	public Stock addImageStock(String urlImage, Long id) {
		Stock s =stockRepository.findByIdStock(id); 
		s.setUrlImage(urlImage); 
		return stockRepository.save(s);
	}

	@Override
	public List<Stock> searchAdvancedStocks(String mot) {
		List<Stock> stocks= stockRepository.searchAdvancedStocks(mot);
		String msg="";
		for(Stock stock : stocks) {
			System.out.println(msg="quantité " + stock.getQteStock()+"< "+ stock.getQteMin());
		}
		return stocks;
	}

}
