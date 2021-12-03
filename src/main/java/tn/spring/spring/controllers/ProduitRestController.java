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

import tn.spring.spring.entity.Produit;
import tn.spring.spring.entity.Stock;
import tn.spring.spring.services.IProduit;
import tn.spring.spring.services.IStock;

@RestController
public class ProduitRestController {

	@Autowired
	IProduit produitService;
	
	@Autowired 
	IStock stockService;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getClients() {
		List<Produit> listProduits = produitService.retrieveAllProduits();
		return listProduits;
	}

	//http://localhost:8080/SpringMVC/servlet/get-produit/5	
	@GetMapping("/get-produit/{id}")
	@ResponseBody
	public Produit getProduit(@PathVariable("id") Long produitId) {
		Produit p = produitService.retrieveProduit(produitId);
		return p;
	}

	// http://localhost:8080/SpringMVC/servlet/add-produit
	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p) {
		Produit produit = produitService.addProduit(p, p.getRayon().getIdRayon(), p.getStock().getIdStock());
		return produit;
	}
	
	
	@PutMapping("/affecterToStock/{idP}/{idS}")
	@ResponseBody
	void affecterProduitToStock(@PathVariable("idP") Long idProduit,@PathVariable("idS") Long idStock) {
		produitService.affecterProduitToStock(idProduit, idStock);
	}
	
	@PutMapping("/affecterToRayon/{idP}/{idR}")
	@ResponseBody
	void affecterProduitToRayon(@PathVariable("idP") Long idProduit,@PathVariable("idR") Long idRayon) {
		produitService.affecterProduitToRayon(idProduit, idRayon);
	}

	// http://localhost:8080/SpringMVC/servlet/update-produit/5
	@PutMapping("update-produit/{id}")
	@ResponseBody
	public Produit updateProduit(@PathVariable("id") Long id, @RequestBody Produit p) {
		Produit produit = produitService.updateProduit(p);
		return produit;
	}

	//http://localhost:8080/SpringMVC/servlet/delete-produit/7
	@DeleteMapping("delete-produit/{id}")
	@ResponseBody
	public void deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteProduit(id);
	}

}
