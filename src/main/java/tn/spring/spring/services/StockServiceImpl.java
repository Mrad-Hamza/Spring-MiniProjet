package tn.spring.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.Stock;
import tn.spring.spring.repository.RayonRepository;
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
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteByIdStock(id);
		
	}

	@Override
	public Stock updateStock(Stock s) {
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		return stockRepository.findByIdStock(id);
	}

}
