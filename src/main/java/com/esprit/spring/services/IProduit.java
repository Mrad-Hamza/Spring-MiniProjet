package com.esprit.spring.services;

import java.util.Date;
import java.util.List;

import com.esprit.spring.entites.Produit;

public interface IProduit {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit c);

	void deleteProduit(Long id);

	Produit updateProduit(Produit u);

	Produit retrieveProduit(Long id);

	

	void affecterProduitToStock(Long idProduit, Long IdStock);
	void affecterProduitToDetail(Long idProduit, Long idDetailP);
	void affecterProduitToRayon(Long idProduit, Long idRayon);
	List<Produit> listProductsByCat( String motCle);

	

	void addProduitToFornisseur(Long id_produit, Long idfournisseur);

	Produit ajoutProduit(Produit p, Long idRayon, Long idStock);

	Produit ajoutProduit(Produit p);

	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
	
}
