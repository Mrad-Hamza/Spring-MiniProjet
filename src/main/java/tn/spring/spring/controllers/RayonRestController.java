package tn.spring.spring.controllers;

import java.util.Date;
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

import tn.spring.spring.entity.ImagesRayon;
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
	
	@GetMapping("/retrieve-all-rayons-true")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayonsTrue() {
		List<Rayon> listRayons = rayonService.retrieveActive();
		return listRayons;
	}

	@GetMapping("/retrieve-all-rayons-false")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayonsFalse() {
		List<Rayon> listRayons = rayonService.retrieveDeleted();
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

	@GetMapping("/recherche-rayon/{string}")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> rechercheRayon(@PathVariable("string") String rech) {
		List<Rayon> r = rayonService.rechercheAvancee(rech);
		return r;
	}

	@GetMapping("/rayon-sortASC")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayonsSortedASC(){
		List<Rayon> allRayons = rayonService.retrieveAllRayonsSortedASC();
		return allRayons;
	}
	@GetMapping("/rayon-sortDESC")
	@ResponseBody
	@CrossOrigin
	public List<Rayon> getRayonsSortedDESC(){
		List<Rayon> allRayons = rayonService.retrieveAllRayonsSortedDESC();
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

	// http://localhost:8080/SpringMVC/servlet/delete-by-state-rayon/{id}
	@PutMapping("delete-by-state-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public Rayon deleteByStateRayon(@PathVariable("id") Long id) {
		Rayon rayon = rayonService.deleteRayonByState(id);
		System.out.println(rayon.toString());
		return rayon;
	}

	//http://localhost:8080/SpringMVC/servlet/delete-rayon/7
	@DeleteMapping("delete-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public void deleteRayon(@PathVariable("id") Long id) {
		rayonService.deleteRayon(id);
	}
	
	
	// Statistique part 1 
	
	@GetMapping("/get-rayon-created-last-month")
	@ResponseBody
	@CrossOrigin
	public int getRayonCreatedLastMonth(){
		return rayonService.getCreatedNumberLastMonth();
	}
	
	@GetMapping("/get-rayon-created-last-week")
	@ResponseBody
	@CrossOrigin
	public int getRayonCreatedLastWeek(){
		return rayonService.getCreatedNumberLastWeek();
	}
	@GetMapping("/get-rayon-created-last-six-months")
	@ResponseBody
	@CrossOrigin
	public int getRayonCreatedLastSixMonth(){
		return rayonService.getCreatedNumberLast6Months();
	}
	@GetMapping("/get-rayon-created-last-year")
	@ResponseBody
	@CrossOrigin
	public int getRayonCreatedLastYear(){
		return rayonService.getCreatedNumberLastYear();
	}

	@GetMapping("/get-rayon-deleted-last-month")
	@ResponseBody
	@CrossOrigin
	public int getRayonDeletedLastMonth(){
		return rayonService.getDeletedNumberLastMonth();
	}
	@GetMapping("/get-rayon-deleted-last-week")
	@ResponseBody
	@CrossOrigin
	public int getRayondeletedLastWeek(){
		return rayonService.getDeletedNumberLastWeek();
	}
	@GetMapping("/get-rayon-deleted-last-six-months")
	@ResponseBody
	@CrossOrigin
	public int getRayonDeletedLastSixMonth(){
		return rayonService.getDeletedNumberLast6Months();
	}
	@GetMapping("/get-rayon-deleted-last-year")
	@ResponseBody
	@CrossOrigin
	public int getRayonDeletedLastYear(){
		return rayonService.getDeletedNumberLastYear();
	
	}
	
	
	
	// Statistique part 2
	
	@GetMapping("/get-top-days-created")
	@ResponseBody
	@CrossOrigin
	public List<Object> getTopDaysCreated(){
		return rayonService.getTopDaysCreated();
	}
	@GetMapping("/get-top-months-created")
	@ResponseBody
	@CrossOrigin
	public List<Object> getTopMonthsCreated(){
		return rayonService.getTopMonthsCreated();
	}
	@GetMapping("/get-top-days-deleted")
	@ResponseBody
	@CrossOrigin
	public List<Object> getTopDaysDeleted(){
		return rayonService.getTopDaysDeleted();
	}
	@GetMapping("/get-top-months-deleted")
	@ResponseBody
	@CrossOrigin
	public List<Object> getTopMontsDeleted(){
		return rayonService.getTopMonthsDeleted();
	}
	
	
	
	// STATISTIQUES PART 3 
	
	@GetMapping("/get-nb-created-by-dates/{d1}/{d2}")
	@ResponseBody
	@CrossOrigin
	public Integer getNbCreatedAndDeletedByDays(@PathVariable("d1") String d1,@PathVariable("d2") String d2){
		System.out.println(d1+d2);
		return rayonService.getNbCreatedByDates(d1, d2);
	}
	@GetMapping("/get-nb-deleted-by-dates/{d1}/{d2}")
	@ResponseBody
	@CrossOrigin
	public Integer getNbDeletedByDays(@PathVariable("d1") String d1,@PathVariable("d2") String d2){
		System.out.println(d1+d2);
		return rayonService.getNbDeletededByDates(d1, d2);
	}
	
}
