package com.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import com.esprit.spring.entites.Client;

public interface IClient {
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client u);

	Client retrieveClient(Long id);
	Optional<Client> findById(Long id);

	Client findByEmail(String email);
	Client findByUsername(String username);
}
