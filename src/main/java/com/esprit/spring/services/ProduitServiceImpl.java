package com.esprit.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.entites.Fournisseur;
import com.esprit.spring.entites.Produit;
import com.esprit.spring.entites.Rayon;
import com.esprit.spring.entites.Stock;
import com.esprit.spring.repository.DetailProduitRepository;
import com.esprit.spring.repository.FournisseurRepository;
import com.esprit.spring.repository.ProduitRepository;
import com.esprit.spring.repository.RayonRepository;
import com.esprit.spring.repository.StockRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j  //equivalent instance de logger
public class ProduitServiceImpl implements IProduit {
	@Autowired
	FournisseurRepository fournisseurRepository;
@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private DetailProduitRepository detailPRepository;
	@Autowired
	private RayonRepository rayonRepository;
	@Autowired
	private IRayon rynServiceImpl;
	@Autowired
	private IStock stkServiceImpl;
	@Autowired
	private IDetailProduit prodDetServiceImpl;
	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		return produits;}
	@Override
	public Produit addProduit(Produit p) {
		// TODO Auto-generated method stub
		produitRepository.save(p);
		return p;
	}


	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);

	}

	@Override
	public Produit updateProduit(Produit u) {
		// TODO Auto-generated method stub
		return produitRepository.save(u);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		Produit produit = produitRepository.findById(id).orElse(null);
		return produit;
	}

	
	@Override
	public void affecterProduitToStock(Long idProduit,Long idStock){
		Produit produit = produitRepository.findById(idProduit).orElse(null);
		Stock stock = stockRepository.findById(idStock).orElse(null);
		produit.setStock(stock);
		produitRepository.save(produit);
	
	}
	@Override
	public void affecterProduitToDetail(Long idProduit,Long idDetailP){
		Produit produit = produitRepository.findById(idProduit).orElse(null);
		DetailProduit detailProduit = detailPRepository.findById(idDetailP).orElse(null);
		produit.setDetailProduit(detailProduit);
		produitRepository.save(produit);
	
	}
	public void affecterProduitToRayon(Long idProduit,Long idRayon){
		Produit produit = produitRepository.findById(idProduit).orElse(null);
		Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
		produit.setRayon(rayon);
		produitRepository.save(produit);
	
	}
	 @Override
	    public List<Produit> listProductsByCat( String motCle) {
	        return this.produitRepository.findAllByCategory_Id(motCle);
	    }
	 @Override
		public void addProduitToFornisseur(Long id_produit,Long idfournisseur){
			Produit produit=produitRepository.findById(id_produit).orElse(null);
			Fournisseur fournisseur= fournisseurRepository.findById(idfournisseur).orElse(null);
			//List<Fournisseur> fournisseurs=new List<Fournisseur>();
		//	fournisseurs
			produit.getFournisseurs().add(fournisseur);
			produitRepository.save(produit);

		}
		
	
	 @Override
		public Produit ajoutProduit(Produit p) {
		 Rayon rayon= rayonRepository.findById(p.getRayon().getIdRayon()).orElse(null);
			Stock stock= stockRepository.findById(p.getStock().getIdStock()).orElse(null);
			p.setRayon(rayon);
			p.setStock(stock);
			DetailProduit dp= saveDetailProduit(p);
			p.setDetailProduit(dp);
			produitRepository.save(p);
			return p;
		}
		private DetailProduit saveDetailProduit(Produit p) {
			if(p.getDetailProduit().getDateCreation()==null) {
				p.getDetailProduit().setDateCreation(new Date());
				p.getDetailProduit().setDateDernierModification(new Date());
			}else {
				p.getDetailProduit().setDateDernierModification(new Date());
			}
			DetailProduit dp = detailPRepository.save(p.getDetailProduit());
			return dp;

		}
		/*@Override
		public Produit ajoutProduit(Produit p, Long idRayon, Long idStock) {
			Rayon rayon= rayonRepository.findById(p.getRayon().getIdRayon()).orElse(null);
			Stock stock= stockRepository.findById(p.getStock().getIdStock()).orElse(null);
			p.setRayon(rayon);
			p.setStock(stock);
			DetailProduit dp= saveDetailProduit(p);
			p.setDetailProduit(dp);
			produitRepository.save(p);
			return p;
		}*/
		@Override
		public Produit ajoutProduit(Produit p, Long idRayon, Long idStock) {
			p.setRayon(rynServiceImpl.retrieveRayon(idRayon));
			p.setStock(stkServiceImpl.retrieveStock(idStock));
			DetailProduit dp = p.getDetailProduit();
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			try {
				dp.setDateCreation(formatter.parse(formatter.format(date)));
				dp.setDateDernierModification(formatter.parse(formatter.format(date)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			prodDetServiceImpl.addDetailProduit(dp);
			return produitRepository.save(p);
		}
		@Override
		public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
			return produitRepository.getRevenuBrutProduit(idProduit, startDate, endDate);
		}
}
