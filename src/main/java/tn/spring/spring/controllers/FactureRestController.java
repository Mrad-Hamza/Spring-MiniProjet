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

import tn.spring.spring.entity.Facture;
import tn.spring.spring.entity.Produit;
import tn.spring.spring.services.IFacture;

@RestController
public class FactureRestController {
	
	@Autowired
	IFacture factureService;
	
	// http://localhost:8080/SpringMVC/servlet/retrieve-all-factures
		@GetMapping("/retrieve-all-factures")
		@ResponseBody
		public List<Facture> getFactures() {
			List<Facture> listProduits = factureService.retrieveAllFactures();
			return listProduits;
		}

		//http://localhost:8080/SpringMVC/servlet/get-facture/5	
		@GetMapping("/get-facture/{id}")
		@ResponseBody
		public Facture getFacture(@PathVariable("id") Long factureId) {
			Facture f = factureService.retrieveFacture(factureId);
			return f;
		}

		// http://localhost:8080/SpringMVC/servlet/add-facture
		@PostMapping("/add-facture")
		@ResponseBody
		public Facture addFacture(@RequestBody Facture f) {
			Facture facture = factureService.addFacture(f);
			return facture;
		}

		// http://localhost:8080/SpringMVC/servlet/update-facture/5
		@PutMapping("update-facture/{id}")
		@ResponseBody
		public Facture updateFacture(@PathVariable("id") Long id, @RequestBody Facture f) {
			Facture facture = factureService.updateFacture(f);
			return facture;
		}

		//http://localhost:8080/SpringMVC/servlet/delete-facture/7
		@DeleteMapping("delete-facture/{id}")
		@ResponseBody
		public void deleteFacture(@PathVariable("id") Long id) {
			factureService.deleteFacture(id);
		}

}
