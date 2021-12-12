package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.DetailProduit;
@Repository
public interface DetailProduitRepository  extends JpaRepository<DetailProduit, Long>{

}
