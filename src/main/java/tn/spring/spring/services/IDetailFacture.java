package tn.spring.spring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.spring.spring.entity.DetailFacture;

public interface IDetailFacture {
	List<DetailFacture> retrieveAllDetailsFactures();

	DetailFacture addDetailFacture(DetailFacture detailF);

	@Transactional
	void deleteDetailFacture(Long id);

	DetailFacture updateDetailFacture(DetailFacture f);

	DetailFacture retrieveDetailFacture(Long id);
}
