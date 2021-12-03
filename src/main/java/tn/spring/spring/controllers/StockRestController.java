package tn.spring.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.spring.entity.Stock;
import tn.spring.spring.services.IStock;

@RestController
public class StockRestController {

	@Autowired
	IStock stockService;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks() {
		List<Stock> listStocks = stockService.retrieveAllStocks();
		return listStocks;
	}

	//http://localhost:8080/SpringMVC/servlet/get-stock/5	
	@GetMapping("/get-stock/{id}")
	@ResponseBody
	public Stock getStock(@PathVariable("id") Long stockId) {
		Stock s = stockService.retrieveStock(stockId);
		return s;
	}

	// http://localhost:8080/SpringMVC/servlet/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s) {
		Stock stock = stockService.addStock(s);
		return stock;
	}

	// http://localhost:8080/SpringMVC/servlet/update-stock/5
	@PutMapping("update-stock/{id}")
	@ResponseBody
	public Stock updateStock(@PathVariable("id") Long id, @RequestBody Stock s) {
		Stock stock = stockService.updateStock(s);
		return stock;
	}

	//http://localhost:8080/SpringMVC/servlet/delete-stock/7
	@DeleteMapping("delete-stock/{id}")
	@ResponseBody
	public void deleteStock(@PathVariable("id") Long id) {
		stockService.deleteStock(id);
	}

}
