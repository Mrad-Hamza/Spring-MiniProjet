package com.esprit.spring.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.CategorieProduit;
import com.esprit.spring.entites.DetailFacture;
import com.esprit.spring.entites.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	   @Query("select p from Produit p where p.libelleProduit like :motCle"  )
	public List<Produit> findAllByCategory_Id( @Param("motCle") String motCle);
	 //  @Query("SELECT (p.prixUnitaire*count(p)) FROM Produit p, DetailFacture d WHERE (p.idProduit = :idProduit) AND (d.produit.idProduit = :idProduit) AND (d.facture.dateFacture BETWEEN :date1 AND :date2)")
		//float getRevenuBrutProduit(@Param("idProduit")Long idProduit,@Param("date1")Date date1,@Param("date2") Date date2);
		@Query("select df from DetailFacture df where (produit.idProduit= :id) and (facture.dateFacture between :date1 and :date2)")
		List<DetailFacture> getRevenueBrut(@Param("id")Long idProd , @Param("date1")Date d1 , @Param("date2")Date d2);
		
	   @Query("select p from Produit p where p.detailProduit.dateCreation BETWEEN :startDate AND :endDate ")
	   List<Produit> ProduitParDateCreation(@Param("startDate") Date date1,@Param("endDate") Date date2);
	   	
	   @Query("select p from Produit p  where p.detailProduit.categorieProduit= :categorie")
		List<Produit> getProduitsByCategorie(@Param("categorie") CategorieProduit categorieProduit );

}
