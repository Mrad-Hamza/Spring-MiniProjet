package tn.spring.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
	public Produit save(Produit p);

	public Produit findByIdProduit(Long id);

	public void deleteByIdProduit(Long id);

	

}
