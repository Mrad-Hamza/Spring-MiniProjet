package com.esprit.spring.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.esprit.spring.services.IClient;
import com.esprit.spring.services.UserDetailsImpl;
import com.esprit.spring.entites.Client;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.response.JwtResponse;
import com.esprit.spring.response.ResponseHandler;
import com.esprit.spring.security.jwt.JwtUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client")

public class ClientRestController {
	
@Autowired
private ClientRepository clientRepository;

@Autowired
PasswordEncoder encoder;

@Autowired
private PasswordEncoder passwordEncoder;

@Autowired
IClient clientService;

@Autowired
private AuthenticationManager authenticationManager;


@Autowired
JwtUtils jwtUtils;



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




@PostMapping("/add-clientParEmail")

@ResponseBody

public ResponseEntity<Object> addClientParEmail(@RequestBody Client c) 

{
	if (clientService.findByUsername(c.getUsername() )!= null) {
		return ResponseHandler.generateResponse(1,"Usename exist",HttpStatus.OK, "");
		
	}
	
	else if (clientService.findByEmail(c.getEmail() )!= null) {
		return ResponseHandler.generateResponse(2,"Email exist", HttpStatus.OK, "");
		

	} else {

		
		c.setPassword(encoder.encode(c.getPassword()));

		Client client = clientService.addClient(c);
		return ResponseHandler.generateResponse(3,"Inscription avec succees", HttpStatus.OK, client);
	}
	 
	



}





@GetMapping("/")
public String home() {

	return "home page";
}

@GetMapping("/admin")
public String homeAdmin() {

	return "This is admin page";
}
@GetMapping("/user")
public String homeUser() {
	return "This is user page";
}
}
