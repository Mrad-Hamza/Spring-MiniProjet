package com.esprit.spring.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.esprit.spring.entites.Produit;
import com.esprit.spring.entites.Rayon;
import com.esprit.spring.entites.Stock;
import com.esprit.spring.services.IDetailProduit;
import com.esprit.spring.services.IProduit;
import com.esprit.spring.services.IStock;




		@RestController
		@CrossOrigin(origins = "http://localhost:4200")
		@RequestMapping("/produit")

	public class ProduitRestController {
			@Autowired
			IProduit produitService;
			IStock stockService;
			IDetailProduit detailpService;
			@GetMapping("/retrieve-all-produits")
			
			@ResponseBody
			public List<Produit>getProduits(){
				List<Produit> listProduits =produitService.retrieveAllProduits();
				return listProduits;
				
			}
			
			

			@PostMapping("/add-Produits/{idRayon}/{idStock}")
			
			@ResponseBody

			public Produit addProduit(@RequestBody Produit c, @PathVariable Long idRayon,@PathVariable Long idStock)

			{Stock stock = new Stock();
			stock.setIdStock(2);
			Rayon rayon = new Rayon();
			rayon.setIdRayon(3);
			c.setRayon(rayon);
			
		        c.setStock(stock);
				Produit produit= produitService.ajoutProduit(c);

			return produit;

			}
			@PostMapping("/add-Produit2")
			
			@ResponseBody

			public Produit addProduit2(@PathVariable String c) {
				Produit p = new Produit();
				p.setCodeProduit(c);
				Produit produit= produitService.ajoutProduit(p);

				return produit;
				
			}
			@DeleteMapping("/remove-produit/{produit-id}")
			
			@ResponseBody

			public void removeProduit(@PathVariable("produit-id") Long id) {

			produitService.deleteProduit(id);

			}
			@PutMapping("/modify-produit")
			@ResponseBody
			public Produit update(@RequestBody Produit produit) {
		        return produitService.updateProduit(produit);
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
			

				@ResponseBody
				public Produit ajoutProduit(@RequestBody Produit p ,@PathVariable("id-rayon") Long idRayon,@PathVariable("id-stock") Long idStock){
					return produitService.ajoutProduit(p, idRayon, idStock);
				

			}
			
			@PostMapping("/add-Produit")
			
			@ResponseBody

			public Produit addProduit(@RequestBody Produit c)

			{

				Produit produit= produitService.addProduit(c);

			return produit;

			}
			@PostMapping("/add-product")
			
			@ResponseBody

			public Produit ajoutProduit(@RequestBody Produit c) {
				long x=2;
				Produit product = produitService.ajoutProduit(c,x,x);
				return product;
			}
			
			
			
			
			@GetMapping("/revenubrut/{produit-id}")
			@ResponseBody
			
			public float RevenuBrutProduit(@PathVariable("produit-id") Long produitId) {
				Date date1= new Date();
				Date date2= new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
				try {
					date1 = simpleDateFormat.parse("2021-10-01");
					date2 = simpleDateFormat.parse("2021-12-02");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				return produitService.getRevenuBrutProduit(produitId,date1,date2);
			}


}
