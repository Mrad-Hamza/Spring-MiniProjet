package tn.spring.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.DetailFacture;

@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture,Long> {
	public DetailFacture save(DetailFacture detailF);

	public DetailFacture findByIdDetailFacture(Long id);

	public void deleteByIdDetailFacture(Long id);
}
