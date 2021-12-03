package tn.spring.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.Rayon;

@Repository
public interface RayonRepository extends JpaRepository<Rayon,Long> {
	public Rayon save(Rayon r);

	public Rayon findByIdRayon(Long id);
	
	public List<Rayon> findByState(Long id);

	public void deleteByIdRayon(Long id);
	
	@Query("SELECT r FROM Rayon r WHERE r.codeRayon like %:string% OR r.libelleRayon like %:string%")
	public List<Rayon> rech(@Param("string") String string);

	@Query("SELECT r FROM Rayon r, Produit p WHERE p.prixUnitaire>= :min AND p.prixUnitaire <= :max")
	public List<Rayon> filterByProductPrice(@Param("min") Float min,@Param("max") Float max);
	

	
}
