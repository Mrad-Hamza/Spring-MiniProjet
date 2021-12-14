package tn.spring.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.ImagesRayon;
import tn.spring.spring.entity.Rayon;

@Repository
public interface RayonRepository extends JpaRepository<Rayon,Long> {
	public Rayon save(Rayon r);

	public Rayon findByIdRayon(Long id);
	
	public List<Rayon> findByState(Boolean etat);

	public void deleteByIdRayon(Long id);
	
	@Query("SELECT r FROM Rayon r WHERE r.codeRayon like %:string% OR r.libelleRayon like %:string%")
	public List<Rayon> rech(@Param("string") String string);

	@Query("SELECT r FROM Rayon r, Produit p WHERE r.idRayon= p.rayon.idRayon AND r.state=1 AND p.prixUnitaire >= :min AND p.prixUnitaire <=:max")
	public List<Rayon> filterByProductPrice(@Param("min") Float min,@Param("max") Float max);
	
	@Query("SELECT r FROM Rayon r WHERE r.state=1 ORDER BY r.libelleRayon ASC")
	public List<Rayon> sortASC();
	
	@Query("SELECT r FROM Rayon r WHERE r.state=1 ORDER BY r.libelleRayon DESC")
	public List<Rayon> sortDESC();
	
	@Query("SELECT r, COUNT(p.idProduit) AS count_p FROM Rayon r, Produit p WHERE r.idRayon= p.rayon.idRayon AND r.state=1 GROUP BY r.idRayon ORDER BY count_p DESC")
	public List<Rayon> sortByProductsNumber();
	
	
	
	// STATS FOR ANGULAR DASHBOARD
	
	
	// Statistiques : Part 1 
	// Nombre de created et deleted 
	// filtre by week, month, 6 months , year
	
	@Query("SELECT COUNT(*) FROM Rayon r WHERE r.state=1 AND DATEDIFF(NOW(),r.createdAt) BETWEEN 0 AND 30")
	public int getCreatedNumberLastMonth();
	
	@Query("SELECT COUNT(*) FROM Rayon r WHERE r.state=1 AND DATEDIFF(NOW(),r.createdAt) BETWEEN 0 AND 180")
	public int getCreatedNumberLast6Months();
	
	@Query("SELECT COUNT(*) FROM Rayon r WHERE r.state=1 AND DATEDIFF(NOW(),r.createdAt) BETWEEN 0 AND 360")
	public int getCreatedNumberLastYear();
	
	@Query("SELECT COUNT(*) FROM Rayon r WHERE r.state=1 AND DATEDIFF(NOW(),r.createdAt) BETWEEN 0 AND 7")
	public int getCreatedNumberLastWeek();
	
	@Query("SELECT COUNT(*) FROM Rayon r WHERE r.state=0 AND DATEDIFF(NOW(),r.deleteAt) BETWEEN 0 AND 30")
	public int getDeleteNumberLastMonth();
	
	@Query("SELECT COUNT(*) FROM Rayon r WHERE r.state=0 AND DATEDIFF(NOW(),r.deleteAt) BETWEEN 0 AND 180")
	public int getDeleteNumberLast6Months();
	
	@Query("SELECT COUNT(*) FROM Rayon r WHERE r.state=0 AND DATEDIFF(NOW(),r.deleteAt) BETWEEN 0 AND 360")
	public int getDeletedNumberLastYear();
	
	@Query("SELECT COUNT(*) FROM Rayon r WHERE r.state=0 AND DATEDIFF(NOW(),r.deleteAt) BETWEEN 0 AND 7")
	public int getDeletedNumberLastWeek();
	
	
	// Statistiques part 2 
	// get best days, months and year were accounts were created or deleted !!! 
	
	
	@Query("SELECT DAYNAME(r.createdAt) AS day, COUNT(EXTRACT(DAY FROM r.createdAt)) AS value_occurrence FROM Rayon r WHERE r.state=1 GROUP BY DAYNAME(r.createdAt) ORDER BY value_occurrence DESC")
	public List<Object> getTopDaysCreated();
	
	@Query("SELECT MONTHNAME(r.createdAt) AS day, COUNT(EXTRACT(MONTH FROM r.createdAt)) AS value_occurrence FROM Rayon r WHERE r.state=1 GROUP BY MONTHNAME(r.createdAt) ORDER BY value_occurrence DESC")
	public List<Object> getTopMonthsCrated();
	

	
	@Query("SELECT DAYNAME(r.deleteAt) AS day, COUNT(EXTRACT(DAY FROM r.deleteAt)) AS value_occurrence FROM Rayon r WHERE r.state=0 GROUP BY DAYNAME(r.deleteAt) ORDER BY value_occurrence DESC")
	public List<Object> getTopDaysDeleted();
	
	@Query("SELECT MONTHNAME(r.deleteAt) AS day, COUNT(EXTRACT(MONTH FROM r.deleteAt)) AS value_occurrence FROM Rayon r WHERE r.state=0 GROUP BY MONTHNAME(r.deleteAt) ORDER BY value_occurrence DESC")
	public List<Object> getTopMonthsDeleted();
	
	
	
	
	// Statistique part 3 !!!! 
	// ta3mel Pie chart, ta3tiha soit day or month or year w t5arajlek created and deleted numbers
	// requete sql !:!!!!!!!
	
	@Query(value="SELECT COUNT(*) FROM Rayon r WHERE r.state=1 AND r.created_at between :date and :datee",nativeQuery=true)
	public Integer getNbCreatedByDates(@Param("date")String d1,@Param("datee")String d2);
	
	@Query(value="SELECT COUNT(*) FROM Rayon r WHERE r.state=0 AND r.delete_at between :date and :datee",nativeQuery=true)
	public Integer getNbDeletedByDates(@Param("date")String d1,@Param("datee")String d2);
}
