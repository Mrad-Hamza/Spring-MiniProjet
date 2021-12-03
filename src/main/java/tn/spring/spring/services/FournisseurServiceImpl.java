package tn.spring.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.Fournisseur;
import tn.spring.spring.repository.FournisseurRepository;

@Service
public class FournisseurServiceImpl implements IFournisseur {
	@Autowired
	FournisseurRepository fournisseurRepository;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		List<Fournisseur> allFournisseurs = fournisseurRepository.findAll();
		return allFournisseurs;
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		return fournisseurRepository.save(f);
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteByIdFournisseur(id);
		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		return fournisseurRepository.save(f);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		// TODO Auto-generated method stub
		return fournisseurRepository.findByIdFournisseur(id);
	}
}
