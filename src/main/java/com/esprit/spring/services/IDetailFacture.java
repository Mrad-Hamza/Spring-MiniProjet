package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.DetailFacture;

public interface IDetailFacture {
	List<DetailFacture> retrieveAllDetailFactures();

	DetailFacture addDetailFacture(DetailFacture c);

	void deleteDetailFacture(Long id);

	DetailFacture updateDetailFacture(DetailFacture u);

	DetailFacture retrieveDetailFacture(Long id);

	List<DetailFacture> findAll();
}
