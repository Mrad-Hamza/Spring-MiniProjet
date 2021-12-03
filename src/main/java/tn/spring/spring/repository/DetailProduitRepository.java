package tn.spring.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.DetailProduit;

@Repository
public interface DetailProduitRepository extends JpaRepository<DetailProduit,Long> {
	public DetailProduit save(DetailProduit detailP);

	public DetailProduit findByIdDetailProduit(Long id);

	public void deleteByIdDetailProduit(Long id);
	
	
}
