package com.esprit.spring.controllers;

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

import com.esprit.spring.services.IClient;
import com.esprit.spring.entites.Client;
@RestController
public class ClientRestController {
@Autowired
IClient clientService;
@GetMapping("/retrieve-all-clients")
@ResponseBody
public List<Client>getClients(){
	List<Client> listClients =clientService.retrieveAllClients();
	return listClients;
	
}
@PostMapping("/add-client")

@ResponseBody

public Client addClient(@RequestBody Client c)

{

Client client = clientService.addClient(c);

return client;

}
@DeleteMapping("/remove-client/{client-id}")

@ResponseBody

public void removeClient(@PathVariable("client-id") Long id) {

clientService.deleteClient(id);

}
@PutMapping("/modify-client")

@ResponseBody

public Client modifyClient(@RequestBody Client u) {

return clientService.updateClient(u);

}
@GetMapping("/retrieve-client/{client-id}")

@ResponseBody

public Client retrieveClient(@PathVariable("client-id") Long id) {

return clientService.retrieveClient(id);

}
}
