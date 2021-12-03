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

import tn.spring.spring.entity.DetailFacture;
import tn.spring.spring.entity.Produit;
import tn.spring.spring.services.IDetailFacture;

@RestController
public class DetailFactureRestController {
	@Autowired
	IDetailFacture detailFactureService;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-detail-factures
	@GetMapping("/retrieve-all-detail-factures")
	@ResponseBody
	public List<DetailFacture> getDetailFactures() {
		List<DetailFacture> listDetailFacture = detailFactureService.retrieveAllDetailsFactures();
		return listDetailFacture;
	}

	//http://localhost:8080/SpringMVC/servlet/get-detail-facture/5	
	@GetMapping("/get-detail-facture/{id}")
	@ResponseBody
	public DetailFacture getDetailFacture(@PathVariable("id") Long detailFactureId) {
		DetailFacture detailF = detailFactureService.retrieveDetailFacture(detailFactureId);
		return detailF;
	}

	// http://localhost:8080/SpringMVC/servlet/add-produit
	@PostMapping("/add-detail-facture")
	@ResponseBody
	public DetailFacture addDetailFacture(@RequestBody DetailFacture detailF) {
		DetailFacture detailFacture = detailFactureService.addDetailFacture(detailF);
		return detailFacture;
	}

	// http://localhost:8080/SpringMVC/servlet/update-detail-facture/5
	@PutMapping("update-detail-facture/{id}")
	@ResponseBody
	public DetailFacture updateDetailFacture(@PathVariable("id") Long id, @RequestBody DetailFacture detailF) {
		DetailFacture detailFacture = detailFactureService.updateDetailFacture(detailF);
		return detailFacture;
	}

	//http://localhost:8080/SpringMVC/servlet/delete-detail-facture/7
	@DeleteMapping("delete-detail-facture/{id}")
	@ResponseBody
	public void deleteDetailFacture(@PathVariable("id") Long id) {
		detailFactureService.deleteDetailFacture(id);
	}
}
