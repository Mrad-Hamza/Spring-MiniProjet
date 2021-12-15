package com.esprit.spring.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.spring.entites.CategorieProduit;
import com.esprit.spring.entites.DetailFacture;
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
		Produit prd = produitRepository.getById(id);
		detailPRepository.delete(prd.getDetailProduit());
		produitRepository.deleteById(id);
		

	}

	@Override
	public Produit updateproduit(Produit u) throws RelationNotFoundException{
		Produit existe = this.produitRepository.findById(u.getIdProduit()).orElseThrow(
				() -> new RelationNotFoundException("produit not found with id :" + u.getIdProduit()));
		existe.setCodeProduit(u.getCodeProduit());
		existe.setLibelleProduit(u.getLibelleProduit());
		existe.setPrixUnitaire(u.getPrixUnitaire());
		existe.setRayon(u.getRayon());
		existe.setStock(u.getStock());
		//existe.setFournisseurs(fournisseurRepository.getOne(u.getFournisseurs().stream().findFirst().get().getIdfournisseur()));
        DetailProduit dProduit = existe.getDetailProduit();
		dProduit.setCategorieProduit(u.getDetailProduit().getCategorieProduit());
	
		existe.setDetailProduit(dProduit);

		//dProduit.setCategorieProduit(produit.getDetailProduit().getCategorieProduit());
		//dpRepo.save(dProduit);
		
		//dProduit.setProduit(produit);
		
		return this.produitRepository.save(existe);
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
		public float getRevenueBrut(Long idP, Date d1, Date d2) {
			
			float revenueTot=0;
			List<DetailFacture> list = produitRepository.getRevenueBrut(idP, d1, d2);
			
			for (DetailFacture detailFacture : list) {
				revenueTot += detailFacture.getQte() * produitRepository.findById(idP).get().getPrixUnitaire();
			}
			
			return revenueTot ;
		}

	    @Override
		public List<Produit> retrieveProduitsByCategorie(CategorieProduit categorieProduit) {
			return produitRepository.getProduitsByCategorie(categorieProduit) ;
		}
		
	    
		
		@Override
		public Produit  saveProductToDB(MultipartFile fileName,Produit id) {
		Produit p = new Produit();
		
		String file = StringUtils.cleanPath(fileName.getOriginalFilename());
		if(file.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			p.setFileName(Base64.getEncoder().encodeToString(fileName.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return produitRepository.save(p);
}
		
		
		@Override
		public float getrevenuebrutepatmois(Long idp,Long month) throws ParseException {
			String d1 = "2021-"+month+"-01";
			String d2 = "2021-"+month+"-30";
			Date date1 = new  SimpleDateFormat("yyyy-MM-dd").parse(d1);
			Date date2 = new  SimpleDateFormat("yyyy-MM-dd").parse(d2);
			return this.getRevenueBrut(idp, date1, date2);
		}
		
		@Override
		public Produit bestrevenuebrutparmois(Long month) throws ParseException {
		List<Produit>productsList=	produitRepository.findAll() ;  
		
		Produit P1 =productsList.get(0);
		float rb=getrevenuebrutepatmois(P1.getIdProduit(), month);
		
		for (Produit p:productsList) {
			if(P1!=p) {
			if (getrevenuebrutepatmois(p.getIdProduit(), month)>(getrevenuebrutepatmois(P1.getIdProduit(),month))) {
				P1=p;
				rb=getrevenuebrutepatmois(P1.getIdProduit(), month);
			}}
		}  
		if(rb==0)
		{return null;}
		
		else  {
			
			return P1;
		}
		
			
		}
	  
		@Override
		public Map<String, String> Listbestrevenuebruteproduitdechaquemois() throws ParseException {
			long months[] = {01,02,03,04,05,06,07,8,9,10,11,12};
			String months1[] = {"January", "February", "March", "April", "May", "June", 
			           "July", "August", "September", "October", "November", "December"};
			
			Map<String,String>listproductMap=new  TreeMap<String, String>(new Comparator<String>()
		    {
		        public int compare(String o1, String o2)
		        {
		            return o1.compareTo(o2);
		        } 
		}) ;
		
			for (int i = 0; i < months.length; i++) {
				if(bestrevenuebrutparmois(months[i])!=null) {
					listproductMap.put(months1[i], bestrevenuebrutparmois(months[i]).getLibelleProduit());}
				else {
					listproductMap.put(months1[i], "");
				}
				
			}
					
					return listproductMap;
		}
}
