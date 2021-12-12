package com.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.DetailFacture;
import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.repository.DetailProduitRepository;
import com.esprit.spring.services.IDetailFacture;
import com.esprit.spring.services.IDetailProduit;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/detailproduit")
	@RestController
public class DetailProduitRestController {
		@Autowired
		IDetailFacture detailfService;
		@GetMapping("/retrieve-all-detailf")
		@ResponseBody
		public List<DetailFacture>getDetailFactures(){
			List<DetailFacture> listDetailFactures =detailfService.retrieveAllDetailFactures();
			return listDetailFactures;
			
		}
		@PostMapping("/add-detailf")

		@ResponseBody

		public DetailFacture addDetailFacture(@RequestBody DetailFacture c)

		{

			DetailFacture detailFacture = detailfService.addDetailFacture(c);

		return detailFacture;

		}
		@DeleteMapping("/remove-datailf/{detailf-id}")

		@ResponseBody

		public void removeDetailFacture(@PathVariable("detailf-id") Long id) {

		detailfService.deleteDetailFacture(id);

		}
}

