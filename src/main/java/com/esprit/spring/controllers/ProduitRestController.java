package com.esprit.spring.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.multipart.MultipartFile;

import com.esprit.spring.entites.CategorieProduit;
import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.entites.Produit;
import com.esprit.spring.entites.Rayon;
import com.esprit.spring.entites.Stock;
import com.esprit.spring.repository.ProduitRepository;
import com.esprit.spring.services.IDetailFacture;
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
	IDetailFacture facturepService;
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
	public Produit modifyProduit(@RequestBody Produit produit) throws RelationNotFoundException {
		return produitService.updateproduit(produit);
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
		
		return produitService.ajoutProduit(c,c.getRayon().getIdRayon(),c.getStock().getIdStock());
		
	}
	
	
	
	
	
	@GetMapping(value="/getProduitsByCategorie/{cp}")
	@ResponseBody
	public List<Produit> retrieveProduitsByCat(@PathVariable("cp") CategorieProduit categorieProduit){
		return produitService.retrieveProduitsByCategorie(categorieProduit) ;
	}
	
	
	
	@PostMapping("/add-p")
	@ResponseBody
	@CrossOrigin
	public 	Produit addImageRayon(@RequestParam("file") MultipartFile fileName,Produit id) throws IOException {
	   // Files.createDirectory(root);
		Produit uploadFile = new Produit();
        uploadFile.setFileName("./assets/images/"+fileName.getOriginalFilename());
     
        //Files.write("./assets/images/"+fileUpload.getOriginalFilename(), fileUpload.getBytes());
        Files.copy(fileName.getInputStream(),this.root.resolve(fileName.getOriginalFilename()));

        Produit imagesRayon = produitService.saveProductToDB(fileName,id);
		return imagesRayon;
	}
	private final Path root = Paths.get("E:\\GestionMagasin-Spring-Angular-main\\src\\assets\\images");

	@GetMapping("/revenueBrut/{id-produit}/{date-debut}/{date-fin}")
	@ResponseBody
	public float getRevenueBrut(@PathVariable("id-produit")Long id,@PathVariable("date-debut") @DateTimeFormat(pattern = "yyyy-MM-dd")Date datestart,@PathVariable("date-fin")@DateTimeFormat(pattern = "yyyy-MM-dd")Date datefin) {
		return produitService.getRevenueBrut(id, datestart, datefin);
	}
	
	
	@GetMapping("/bestrevenueproduits")
	@ResponseBody
	public Map<String, String> MapBestsalesproduits() throws ParseException{
		return produitService.Listbestrevenuebruteproduitdechaquemois();
	}
	
}
