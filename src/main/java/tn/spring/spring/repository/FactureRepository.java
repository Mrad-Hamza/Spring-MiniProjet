package tn.spring.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long>{
	public Facture save(Facture f);

	public Facture findByIdFacture(Long id);

	public void deleteByIdFacture(Long id);
}


