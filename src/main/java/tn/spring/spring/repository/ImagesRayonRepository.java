package tn.spring.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.spring.spring.entity.ImagesRayon;
import tn.spring.spring.entity.Rayon;

public interface ImagesRayonRepository extends JpaRepository<ImagesRayon,Long>{
	public ImagesRayon save(ImagesRayon r);

	public ImagesRayon findByIdImageRayon(Long id);

	public void deleteByIdImageRayon(Long id);
	
	List<ImagesRayon> findByRayon(Rayon r);
	
}
