package tn.spring.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.spring.entity.Client;
import tn.spring.spring.services.IClient;

@RestController
public class ClientRestController {

	@Autowired
	IClient clientService;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-clients
	@GetMapping("/retrieve-all-clients")
	@ResponseBody
	public List<Client> getClients() {
		List<Client> listClients = clientService.retrieveAllClients();
		return listClients;
	}

	// http://localhost:8080/SpringMVC/servlet/add-client
	@PostMapping("/add-client")
	@ResponseBody
	public Client addClient(@RequestBody Client c) {
		Client client = clientService.addClient(c);
		return client;
	}

	//http://localhost:8080/SpringMVC/servlet/get-client/5	
	@GetMapping("/get-client/{id}")
	@ResponseBody
	public Client getClient(@PathVariable("id") Long clientId) {
		Client c = clientService.retrieveClient(clientId);
		return c;
	}

	// http://localhost:8080/SpringMVC/servlet/update-client/5
	@PutMapping("update-client/{id}")
	@ResponseBody
	public Client updateClient(@PathVariable("id") Long id, @RequestBody Client c) {
		Client client = clientService.updateClient(c);
		return client;
	}

	//http://localhost:8080/SpringMVC/servlet/delete-client/7
	@DeleteMapping("delete-client/{id}")
	@ResponseBody
	public void deleteClient(@PathVariable("id") Long id) {
		clientService.deleteClient(id);
	}

}
