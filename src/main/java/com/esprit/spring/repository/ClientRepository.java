package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Client;
@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {

}
