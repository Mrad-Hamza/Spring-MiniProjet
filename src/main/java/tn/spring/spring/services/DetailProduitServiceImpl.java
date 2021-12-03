package tn.spring.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.DetailProduit;
import tn.spring.spring.entity.DetailProduit;
import tn.spring.spring.repository.DetailProduitRepository;

@Service
public class DetailProduitServiceImpl implements IDetailProduit {
	@Autowired
	private DetailProduitRepository detailproduitRepository;


	@Override
	public List<DetailProduit> retrieveAllDetailProduits() {
		// TODO Auto-generated method stub
		List<DetailProduit> produits = (List<DetailProduit>) detailproduitRepository.findAll();
		return produits;
	}

	@Override
	public DetailProduit addDetailProduit(DetailProduit p) {
		// TODO Auto-generated method stub
		detailproduitRepository.save(p);
		return p;
	}

	@Override
	public void deleteDetailProduit(Long id) {
		// TODO Auto-generated method stub
		detailproduitRepository.deleteByIdDetailProduit(id);

	}

	@Override
	public DetailProduit updateDetailProduit(DetailProduit u) {
		// TODO Auto-generated method stub
		return detailproduitRepository.save(u);
	}

	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
		// TODO Auto-generated method stub
		DetailProduit detailProduit = detailproduitRepository.findByIdDetailProduit(id);
		return detailProduit;
	}


}
