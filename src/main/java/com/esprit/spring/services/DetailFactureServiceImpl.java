package com.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.DetailFacture;
import com.esprit.spring.repository.DetailFactureRepository;
@Service
public class DetailFactureServiceImpl  implements IDetailFacture{
	@Autowired
	private DetailFactureRepository detailFactureRepository;


	@Override
	public List<DetailFacture> retrieveAllDetailFactures() {
		// TODO Auto-generated method stub
		List<DetailFacture> DetailFactures = (List<DetailFacture>) detailFactureRepository.findAll();
		return DetailFactures;
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture p) {
		// TODO Auto-generated method stub
		detailFactureRepository.save(p);
		return p;
	}

	@Override
	public void deleteDetailFacture(Long id) {
		// TODO Auto-generated method stub
		detailFactureRepository.deleteById(id);

	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture u) {
		// TODO Auto-generated method stub
		return detailFactureRepository.save(u);
	}

	@Override
	public DetailFacture retrieveDetailFacture(Long id) {
		// TODO Auto-generated method stub
		DetailFacture DetailFacture = detailFactureRepository.findById(id).orElse(null);
		return DetailFacture;
	}
	
	  @Override
	    public List<DetailFacture> findAll() {
	        return detailFactureRepository.findAll();
	    }
}
