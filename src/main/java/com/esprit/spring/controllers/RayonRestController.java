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


import com.esprit.spring.entites.Rayon;
import com.esprit.spring.services.IRayon;
@RestController
public class RayonRestController {
	



	@Autowired
	IRayon rayonService;
	@GetMapping("/retrieve-all-rayons")
	@CrossOrigin
	@ResponseBody
	public List<Rayon>getRayons(){
		List<Rayon> listRayons =rayonService.retrieveAllRayons();
		return listRayons;
		
	}
	@PostMapping("/add-Rayon")

	@ResponseBody

	public Rayon addRayon(@RequestBody Rayon c)

	{

		Rayon rayon= rayonService.addRayon(c);

	return rayon;

	}
	@DeleteMapping("/remove-rayon/{rayon-id}")

	@ResponseBody

	public void removeRayon(@PathVariable("rayon-id") Long id) {

	rayonService.deleteRayon(id);

	}
	@PutMapping("/modify-rayon")

	@ResponseBody

	public Rayon modifyRayon(@RequestBody Rayon u) {

	return rayonService.updateRayon(u);

	}
	@GetMapping("/retrieve-rayon/{rayon-id}")

	@ResponseBody

	public Rayon retrieveRayon(@PathVariable("rayon-id") Long id) {

	return rayonService.retrieveRayon(id);

	}
}
