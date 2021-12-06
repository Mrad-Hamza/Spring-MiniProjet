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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.esprit.spring.entites.DetailProduit;
import com.esprit.spring.services.IDetailProduit;

	@RestController
public class DetailProduitRestController {
		@Autowired
		IDetailProduit detailpService;
		@GetMapping("/retrieve-all-detailp")
		@CrossOrigin

		@ResponseBody
		public List<DetailProduit>getDetailProduits(){
			List<DetailProduit> listDetailProduits =detailpService.retrieveAllDetailProduits();
			return listDetailProduits;
			
		}
		@PostMapping("/add-detailp")
		@CrossOrigin

		@ResponseBody

		public DetailProduit addDetailProduit(@RequestBody DetailProduit c)

		{

			DetailProduit detailProduit = detailpService.addDetailProduit(c);

		return detailProduit;

		}

@DeleteMapping("/remove-datailp/{detailp-id}")

@ResponseBody

public void removeDetailProduit(@PathVariable("detailp-id") Long id) {

detailpService.deleteDetailProduit(id);

}
@PutMapping("/modify-detailp")

@ResponseBody

public DetailProduit modifyDetailProduit(@RequestBody DetailProduit u) {

return detailpService.updateDetailProduit(u);

}
@GetMapping("/retrieve-detailp/{detailp-id}")

@ResponseBody

public DetailProduit retrieveDetailProduit(@PathVariable("datailp-id") Long id) {

return detailpService.retrieveDetailProduit(id);

}
}

