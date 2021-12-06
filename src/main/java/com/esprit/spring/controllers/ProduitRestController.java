package com.esprit.spring.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.entites.Produit;
import com.esprit.spring.entites.Stock;
import com.esprit.spring.repository.ProduitRepository;
import com.esprit.spring.services.IDetailProduit;
import com.esprit.spring.services.IProduit;
import com.esprit.spring.services.IStock;


	@RestController
public class ProduitRestController {


	@Autowired
	IProduit produitService;
	IStock stockService;
	IDetailProduit detailpService;
	@GetMapping("/retrieve-all-produits")
	@CrossOrigin
	@ResponseBody
	public List<Produit>getProduits(){
		List<Produit> listProduits =produitService.retrieveAllProduits();
		return listProduits;
		
	}
	
	

	@PostMapping("/add-Produit")
	@CrossOrigin
	@ResponseBody

	public Produit addProduit(@RequestBody Produit c)

	{

		Produit produit= produitService.addProduit(c);

	return produit;

	}
	@DeleteMapping("/remove-produit/{produit-id}")
@CrossOrigin
	@ResponseBody

	public void removeProduit(@PathVariable("produit-id") Long id) {

	produitService.deleteProduit(id);

	}
	@PutMapping("/modify-produit/{id}")
@CrossOrigin
	@ResponseBody

	   public Produit update( @RequestBody Produit produit,@PathVariable("id") Long id) {
       
      
        return produitService.updateProduit(produit, id);
	}
	@GetMapping("/retrieve-produit/{produit-id}")

	@ResponseBody

	public Produit retrieveProduit(@PathVariable("produit-id") Long id) {

	return produitService.retrieveProduit(id);

	}
	
	@PutMapping("/affectToStock/{id-prod}/{id-stock}")
	@ResponseBody
	public void affectToStock(@PathVariable("id-prod") Long idProduit, @PathVariable("id-stock") Long IdStock) {
		produitService.affecterProduitToStock(idProduit, IdStock);}
		
	@PutMapping("/affectToRayon/{id-prod}/{id-rayon}")
	@ResponseBody
	public void affectToRayon(@PathVariable("id-prod") Long idProduit, @PathVariable("id-rayon") Long idRayon) {
		produitService.affecterProduitToRayon(idProduit, idRayon);
	}
	@PutMapping("/affectToDetailp/{id-prod}/{id-detailp}")
	@ResponseBody
	public void affectToDetailP(@PathVariable("id-prod") Long idProduit, @PathVariable("id-detailp") Long idDetailP) {
		produitService.affecterProduitToDetail(idProduit, idDetailP);
	}

	@GetMapping(value = "/rechercheP/{motCle}")
	public List<Produit> listProductsByCat(  @PathVariable("motCle") String motCle){
                                     
                                   


        
        return produitService.listProductsByCat("%"+motCle+"%");
    }
		
	
	@PostMapping("/addProduitToFournisseur/{id_produit}/{idfournisseur}")
	public void addProduitToFornisseur(@PathVariable("id_produit") Long id_produit,@PathVariable("idfournisseur") Long idfournisseur){
	produitService.addProduitToFornisseur(id_produit, idfournisseur);
}
	
	@PostMapping("/addproduit/{id-rayon}/{id-stock}")
	@CrossOrigin

		@ResponseBody
		public Produit ajoutProduit(@RequestBody Produit p ,@PathVariable("id-rayon") Long idRayon,@PathVariable("id-stock") Long idStock){
			return produitService.ajoutProduit(p, idRayon, idStock);
		

	}
}
