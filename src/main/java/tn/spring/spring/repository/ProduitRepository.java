package tn.spring.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
	
	public Produit save(Produit p);

	public Produit findByIdProduit(Long id);

	public void deleteByIdProduit(Long id);
	
	@Query(value="select * from produit where stock_id_Stock=:id", nativeQuery=true)
	public List<Produit> getProduitsbyIdStocks(@Param("id") Long idStock);

	

}
