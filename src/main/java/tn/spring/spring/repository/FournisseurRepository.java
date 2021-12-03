package tn.spring.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
	public Fournisseur save(Fournisseur f);

	public Fournisseur findByIdFournisseur(Long id);

	public void deleteByIdFournisseur(Long id);

}
