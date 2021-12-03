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

import tn.spring.spring.entity.DetailProduit;
import tn.spring.spring.entity.Produit;
import tn.spring.spring.services.IDetailProduit;

@RestController
public class DetailProduitRestController {
	@Autowired
	IDetailProduit detailProduitService;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-detail-produits
	@GetMapping("/retrieve-all-detail-produits")
	@ResponseBody
	public List<DetailProduit> getDetailProduits() {
		List<DetailProduit> listDetailProduits = detailProduitService.retrieveAllDetailProduits();
		return listDetailProduits;
	}

	//http://localhost:8080/SpringMVC/servlet/get-detail-produit/5	
	@GetMapping("/get-detail-produit/{id}")
	@ResponseBody
	public DetailProduit getDetailProduit(@PathVariable("id") Long detailProduitId) {
		DetailProduit p = detailProduitService.retrieveDetailProduit(detailProduitId);
		return p;
	}

	// http://localhost:8080/SpringMVC/servlet/add-detail-produit
	@PostMapping("/add-detail-produit")
	@ResponseBody
	public DetailProduit addDetailProduit(@RequestBody DetailProduit p) {
		DetailProduit detailProduit = detailProduitService.addDetailProduit(p);
		return detailProduit;
	}

	// http://localhost:8080/SpringMVC/servlet/update-detail-produit/5
	@PutMapping("update-detail-produit/{id}")
	@ResponseBody
	public DetailProduit updateDetailProduit(@PathVariable("id") Long id, @RequestBody DetailProduit p) {
		DetailProduit detailProduit = detailProduitService.updateDetailProduit(p);
		return detailProduit;
	}

	//http://localhost:8080/SpringMVC/servlet/delete-detail-produit/7
	@DeleteMapping("delete-detail-produit/{id}")
	@ResponseBody
	public void deleteDetailProduit(@PathVariable("id") Long id) {
		detailProduitService.deleteDetailProduit(id);
	}
}
