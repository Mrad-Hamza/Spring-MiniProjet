package tn.spring.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.Facture;
import tn.spring.spring.repository.FactureRepository;

@Service
public class FactureServiceImpl implements IFacture {
	
	@Autowired
	FactureRepository factureRepositry;

	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> allFactures = factureRepositry.findAll();
		return allFactures;
	}

	@Override
	public Facture addFacture(Facture f) {
		factureRepositry.save(f);
		return f;
	}

	@Override
	public void deleteFacture(Long id) {
		factureRepositry.deleteByIdFacture(id);
		
	}

	@Override
	public Facture updateFacture(Facture f) {
		// TODO Auto-generated method stub
		return factureRepositry.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		Facture f = factureRepositry.findByIdFacture(id);
		return f;
	}

}
