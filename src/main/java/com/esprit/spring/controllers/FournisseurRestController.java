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

import com.esprit.spring.entites.Fournisseur;
import com.esprit.spring.services.IFournisseur;


	@RestController
	
public class FournisseurRestController {
	@Autowired
	IFournisseur fournisseurService;
	@GetMapping("/retrieve-all-fournisseurs")
	@ResponseBody
	public List<Fournisseur>getFournisseurs(){
		List<Fournisseur> listFournisseurs =fournisseurService.retrieveAllFournisseurs();
		return listFournisseurs;
		
	}
	@PostMapping("/add-fournisseur")

	@ResponseBody

	public Fournisseur addFournisseur(@RequestBody Fournisseur c)

	{

		Fournisseur fournisseur = fournisseurService.addFournisseur(c);

	return fournisseur;

	}
	@DeleteMapping("/remove-fournisseur/{fournisseur-id}")

	@ResponseBody

	public void removeFournisseur(@PathVariable("fournisseur-id") Long id) {

	fournisseurService.deleteFournisseur(id);

	}
	@PutMapping("/modify-fournisseur")

	@ResponseBody

	public Fournisseur modifyFournisseur(@RequestBody Fournisseur u) {

	return fournisseurService.updateFournisseur(u);

	}
	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")

	@ResponseBody

	public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long id) {

	return fournisseurService.retrieveFournisseur(id);

	}
	}

