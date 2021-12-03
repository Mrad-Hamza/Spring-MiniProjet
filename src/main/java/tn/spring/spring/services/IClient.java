package tn.spring.spring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.spring.spring.entity.Client;

public interface IClient {
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	@Transactional
	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
}
