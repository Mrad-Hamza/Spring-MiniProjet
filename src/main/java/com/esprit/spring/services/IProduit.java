package com.esprit.spring.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.entites.Produit;

public interface IProduit {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit c);

	void deleteProduit(Long id);

	Produit updateProduit(Produit u, Long id);

	Produit retrieveProduit(Long id);

	

	void affecterProduitToStock(Long idProduit, Long IdStock);
	void affecterProduitToDetail(Long idProduit, Long idDetailP);
	void affecterProduitToRayon(Long idProduit, Long idRayon);
	List<Produit> listProductsByCat( String motCle);

	

	void addProduitToFornisseur(Long id_produit, Long idfournisseur);

	Produit ajoutProduit(Produit p, Long idRayon, Long idStock);

	

	


	
}
