package com.esprit.spring.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.management.relation.RelationNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.spring.entites.CategorieProduit;
import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.entites.Produit;

public interface IProduit {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit c);

	void deleteProduit(Long id);

	Produit updateproduit(Produit u)throws RelationNotFoundException;

	Produit retrieveProduit(Long id);

	

	void affecterProduitToStock(Long idProduit, Long IdStock);
	void affecterProduitToDetail(Long idProduit, Long idDetailP);
	void affecterProduitToRayon(Long idProduit, Long idRayon);
	List<Produit> listProductsByCat( String motCle);

	

	void addProduitToFornisseur(Long id_produit, Long idfournisseur);

	Produit ajoutProduit(Produit p, Long idRayon, Long idStock);

	Produit ajoutProduit(Produit p);



	Produit saveProductToDB(MultipartFile fileName, Produit id);

	List<Produit> retrieveProduitsByCategorie(CategorieProduit categorieProduit);

	float getRevenueBrut(Long idP, Date d1, Date d2);

	float getrevenuebrutepatmois(Long idp, Long month) throws ParseException;

	Map<String, String> Listbestrevenuebruteproduitdechaquemois() throws ParseException;

	Produit bestrevenuebrutparmois(Long month) throws ParseException;
	
	

	


	
}
