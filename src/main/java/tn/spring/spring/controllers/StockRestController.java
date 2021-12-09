package tn.spring.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.spring.spring.services.IProduit;
import tn.spring.spring.entity.Stock;
import tn.spring.spring.services.IStock;

@RestController
public class StockRestController {

	@Autowired
	IStock stockService;
	IProduit produitService;

	// http://localhost:8098/SpringMVC/servlet/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	@CrossOrigin
	public List<Stock> getStocks() {
		List<Stock> listStocks = stockService.retrieveAllStocks();
		return listStocks;
	}

	// http://localhost:8098/SpringMVC/servlet/retrieveActiveStocks
	@GetMapping("/retrieveActiveStocks")
	@ResponseBody
	@CrossOrigin
	public List<Stock> getActiveStocks() {
		List<Stock> listStocks = stockService.retrieveActiveStocks();
		return listStocks;
	}

	// http://localhost:8098/SpringMVC/servlet/retrievePassiveStocks
	@GetMapping("/retrievePassiveStocks")
	@ResponseBody
	@CrossOrigin
	public List<Stock> getPassiveStocks() {
		List<Stock> listStocks = stockService.retrievePassiveStocks();
		return listStocks;
	}

	//http://localhost:8098/SpringMVC/servlet/get-stock/5	
	@GetMapping("/get-stock/{id}")
	@ResponseBody
	public Stock getStock(@PathVariable("id") Long stockId) {
		Stock s = stockService.retrieveStock(stockId);
		return s;
	}

	// http://localhost:8098/SpringMVC/servlet/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s) {
		Stock stock = stockService.addStock(s);
		return stock;
	}

	// http://localhost:8098/SpringMVC/servlet/update-stock/5
	@PutMapping("update-stock/{id}")
	@ResponseBody
	public Stock updateStock(@PathVariable("id") Long id, @RequestBody Stock s) {
		s.setIdStock(id);
		return stockService.updateStock(s);
	}

	//http://localhost:8098/SpringMVC/servlet/delete-stock/7
	@DeleteMapping("delete-stock/{id}")
	@ResponseBody
	public void deleteStock(@PathVariable("id") Long id) {
		stockService.deleteStock(id);
	}

	//http://localhost:8098/SpringMVC/servlet/search-stock/aaa	
	@GetMapping("/search-stock/{libelle}")
	@ResponseBody
	public Stock searchStockByName(@PathVariable("libelle") String libelle) {
		Stock s = stockService.searchStockByName(libelle);
		return s;
	}

	//http://localhost:8098/SpringMVC/servlet/search-stock-ByQte/2000	
	@GetMapping("/search-stock-By-Qte/{qte}")
	@ResponseBody
	public List<Stock> searchStockByQte(@PathVariable("qte") int qte) {
		List<Stock> stocks = stockService.searchStockByQte(qte);
		return stocks;
	}

	//http://localhost:8098/SpringMVC/servlet/search-stock-By-Status	
	@GetMapping("/search-stock-By-Status")
	@ResponseBody
	public List<Stock> getStockByStatus() {
		List<Stock> stocks = stockService.getStockByStatus();
		return stocks;
	}

	//http://localhost:8098/SpringMVC/servlet/retrieveStatusStock	
	@GetMapping("/retrieveStatusStock")
	@ResponseBody
	public String retrieveStatusStock() {
		return stockService.retrieveStatusStock();

	}

	//http://localhost:8098/SpringMVC/servlet/search-product/yaourt
	/*
	 * @DeleteMapping("search-product/{libelle}")
	 * 
	 * @ResponseBody public Stock searchListProduct(@PathVariable("libelle") String
	 * libelle) { Produit Stock stock = stockService.searchListProduct(libelle);
	 * return stock; }
	 */

}
