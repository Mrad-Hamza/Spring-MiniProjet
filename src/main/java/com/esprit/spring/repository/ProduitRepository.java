package com.esprit.spring.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	   @Query("select p from Produit p where p.libelleProduit like :motCle"  )
	public List<Produit> findAllByCategory_Id( @Param("motCle") String motCle);

	
}
