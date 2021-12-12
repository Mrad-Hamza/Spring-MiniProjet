package com.esprit.spring.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Client;
@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {
	
	
	
	public Client findByEmail(String email);
	public Client findByUsername(String username);
	@Query(value = "SELECT * FROM CLIENT WHERE  USERNAME = ?1", nativeQuery = true)
	public Optional<Client> findByUsernamee(String username);

	@Query(value = "SELECT * FROM CLIENT WHERE  NOM = ?1", nativeQuery = true)
	public Client findByNom(String Nom);
 
	@Query("from Client where email=?1 and password=?2")
	public Client findByEmailPassword(String username,String password);
	
}
