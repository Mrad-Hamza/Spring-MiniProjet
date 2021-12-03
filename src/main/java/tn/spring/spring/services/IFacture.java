package tn.spring.spring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.spring.spring.entity.Facture;

public interface IFacture {
	List<Facture> retrieveAllFactures();

	Facture addFacture(Facture f);

	@Transactional
	void deleteFacture(Long id);

	Facture updateFacture(Facture f);

	Facture retrieveFacture(Long id);
}
