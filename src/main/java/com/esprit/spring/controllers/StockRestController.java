package com.esprit.spring.controllers;

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

import com.esprit.spring.entites.Stock;
import com.esprit.spring.services.IStock;


	@RestController
public class StockRestController {

	
		



		@Autowired
		IStock stockService;
		@GetMapping("/retrieve-all-stocks")
		@CrossOrigin
		@ResponseBody
		public List<Stock>getStocks(){
			List<Stock> listStocks =stockService.retrieveAllStocks();
			return listStocks;
			
		}
		@PostMapping("/add-Stock")

		@ResponseBody

		public Stock addStock(@RequestBody Stock c)

		{

			Stock stock= stockService.addStock(c);

		return stock;

		}
		@DeleteMapping("/remove-stock/{stock-id}")

		@ResponseBody

		public void removeStock(@PathVariable("stock-id") Long id) {

		stockService.deleteStock(id);

		}
		@PutMapping("/modify-stock")

		@ResponseBody

		public Stock modifyStock(@RequestBody Stock u) {

		return stockService.updateStock(u);

		}
		@GetMapping("/retrieve-stock/{stock-id}")

		@ResponseBody

		public Stock retrieveStock(@PathVariable("stock-id") Long id) {

		return stockService.retrieveStock(id);

		}
	}
