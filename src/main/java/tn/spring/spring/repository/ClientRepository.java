package tn.spring.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	public Client save(Client c);

	public Client findByIdClient(Long id);

	public void deleteByIdClient(Long id);
}
