package tn.spring.spring.services;
import tn.spring.spring.entity.Produit;
import tn.spring.spring.entity.Rayon;
import tn.spring.spring.entity.Stock;
import tn.spring.spring.repository.ProduitRepository;
import tn.spring.spring.repository.RayonRepository;
import tn.spring.spring.repository.StockRepository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProduitServiceImpl implements IProduit {
	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private RayonRepository rayonRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		return produits;
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		Rayon rayon = rayonRepository.getById(idRayon);
		Stock stock = stockRepository.getById(idStock);
		p.setRayon(rayon);
		p.setStock(stock);
		produitRepository.save(p);
		return p;
	}
	
	@Override
	public List<Produit> getProduitsbyIdStocks(Long idStock) {
		List<Produit> produits = produitRepository.getProduitsbyIdStocks(idStock);
		return produits;
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteByIdProduit(id);

	}

	@Override
	public Produit updateProduit(Produit u) {
		// TODO Auto-generated method stub
		return produitRepository.save(u);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		Produit produit = produitRepository.findByIdProduit(id);
		return produit;
	}

	@Override
	public void affecterProduitToStock(Long idProduit, Long idStock) {
		Stock s = stockRepository.findByIdStock(idStock);
		Produit produit = produitRepository.findByIdProduit(idProduit);
		produit.setStock(s);
		System.out.println(s.toString());
		produitRepository.save(produit);
		
	}

	@Override
	public void affecterProduitToRayon(Long idProduit, Long idRayon) {
		Rayon r = rayonRepository.findByIdRayon(idRayon);
		Produit produit = produitRepository.findByIdProduit(idProduit);
		produit.setRayon(r);
		produitRepository.save(produit);
	}

}
