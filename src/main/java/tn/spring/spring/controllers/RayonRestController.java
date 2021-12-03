package tn.spring.spring.controllers;

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

import tn.spring.spring.entity.Rayon;
import tn.spring.spring.services.IRayon;

@RestController
public class RayonRestController {
	@Autowired
	IRayon rayonService;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-rayons
	@GetMapping("/retrieve-all-rayons")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayons() {
		List<Rayon> listRayons = rayonService.retrieveAllRayons();
		return listRayons;
	}

	//http://localhost:8080/SpringMVC/servlet/get-rayon/5	
	@GetMapping("/get-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public Rayon getRayon(@PathVariable("id") Long rayonId) {
		Rayon r = rayonService.retrieveRayon(rayonId);
		return r;
	}
	
	@GetMapping("/sortByProductNumbers")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayonSortedByProductNumbers(){
		return rayonService.retrieveAllRayonSortedByProductsNumber(); 
	}
	
	@GetMapping("/recherche/{string}")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> rechercheRayon(@PathVariable("string") String rech) {
		List<Rayon> r = rayonService.rechercheAvancee(rech);
		return r;
	}
	
	@GetMapping("/sortASC")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayonsSorted(){
		List<Rayon> allRayons = rayonService.retrieveAllRayonsSorted();
		return allRayons;
	}
	
	@GetMapping("/filterByPrice/{min}/{max}")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayonFilteredByPrice(@PathVariable("min") float min,@PathVariable("max") float max){
		return rayonService.filterByProductsPrice(min, max);
	}

	// http://localhost:8080/SpringMVC/servlet/add-rayon
	@PostMapping("/add-rayon")
	@ResponseBody
	@CrossOrigin
	public Rayon addRayon(@RequestBody Rayon r) {
		Rayon rayon = rayonService.addRayon(r);
		return rayon;
	}

	// http://localhost:8080/SpringMVC/servlet/update-rayon/5
	@PutMapping("update-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public Rayon updateRayon(@PathVariable("id") Long id, @RequestBody Rayon p) {
		Rayon rayon = rayonService.updateRayon(p);
		return rayon;
	}

	//http://localhost:8080/SpringMVC/servlet/delete-rayon/7
	@DeleteMapping("delete-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public void deleteRayon(@PathVariable("id") Long id) {
		rayonService.deleteRayon(id);
	}
}
