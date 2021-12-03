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

import tn.spring.spring.entity.Fournisseur;
import tn.spring.spring.services.IFournisseur;

@RestController
public class FournisseurRestController {
	@Autowired
	IFournisseur fournisseurService;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-fournisseurs
	@GetMapping("/retrieve-all-fournisseurs")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
		List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseurs();
		return listFournisseurs;
	}

	//http://localhost:8080/SpringMVC/servlet/get-fournisseur/5	
	@GetMapping("/get-fournisseur/{id}")
	@ResponseBody
	public Fournisseur getFournisseur(@PathVariable("id") Long fournisseurId) {
		Fournisseur f = fournisseurService.retrieveFournisseur(fournisseurId);
		return f;
	}

	// http://localhost:8080/SpringMVC/servlet/add-fournisseur
	@PostMapping("/add-fournisseur")
	@ResponseBody
	public Fournisseur addFournisseur(@RequestBody Fournisseur f) {
		Fournisseur fournisseur = fournisseurService.addFournisseur(f);
		return fournisseur;
	}

	// http://localhost:8080/SpringMVC/servlet/update-fournisseur/5
	@PutMapping("update-fournisseur/{id}")
	@ResponseBody
	public Fournisseur updateFournisseur(@PathVariable("id") Long id, @RequestBody Fournisseur f) {
		Fournisseur fournisseur = fournisseurService.updateFournisseur(f);
		return fournisseur;
	}

	//http://localhost:8080/SpringMVC/servlet/delete-fournisseur/7
	@DeleteMapping("delete-fournisseur/{id}")
	@ResponseBody
	public void deleteFournisseur(@PathVariable("id") Long id) {
		fournisseurService.deleteFournisseur(id);
	}

}
