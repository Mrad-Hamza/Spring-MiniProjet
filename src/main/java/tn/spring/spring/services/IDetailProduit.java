package tn.spring.spring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.spring.spring.entity.DetailProduit;

public interface IDetailProduit {
	List<DetailProduit> retrieveAllDetailProduits();

	DetailProduit addDetailProduit(DetailProduit p);

	@Transactional
	void deleteDetailProduit(Long id);

	DetailProduit updateDetailProduit(DetailProduit u);

	DetailProduit retrieveDetailProduit(Long id);
}
