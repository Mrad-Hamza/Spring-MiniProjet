package com.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Client;
import com.esprit.spring.repository.ClientRepository;
@Service
public class ClientServiceImpl implements IClient{
	@Autowired
	private ClientRepository clientRepository;


	@Override
	public List<Client> retrieveAllClients() {
		// TODO Auto-generated method stub
		List<Client> Clients = (List<Client>) clientRepository.findAll();
		return Clients;
	}

	@Override
	public Client addClient(Client p) {
		// TODO Auto-generated method stub
		clientRepository.save(p);
		return p;
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);

	}

	@Override
	public Client updateClient(Client u) {
		// TODO Auto-generated method stub
		return clientRepository.save(u);
	}

	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		Client Client = clientRepository.findById(id).orElse(null);
		return Client;
	}
}
