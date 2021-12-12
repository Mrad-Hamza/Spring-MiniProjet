package com.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Produit;
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
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		c.setRole("USER");
		c.setEnabled(true);
		clientRepository.save(c);
		return c;
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

	
	@Override
	public Optional<Client> findById(Long id) {
		return clientRepository.findById(id);
	}
	 
	@Override
	public Client findByEmail(String email) {
		return clientRepository.findByEmail(email);
	}
	
	@Override
	public Client findByUsername(String username) {
		return clientRepository.findByUsername(username);
	}

	

	
	   
	
	
	
}
