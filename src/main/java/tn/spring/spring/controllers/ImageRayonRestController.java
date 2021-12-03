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

import tn.spring.spring.entity.ImagesRayon;
import tn.spring.spring.entity.Stock;
import tn.spring.spring.services.IImagesRayon;

@RestController
public class ImageRayonRestController {
	@Autowired
	IImagesRayon imageRayonService;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-images-rayon
	@GetMapping("/retrieve-all-images-rayon")
	@ResponseBody
	@CrossOrigin
	public List<ImagesRayon> getStocks() {
		List<ImagesRayon> imagesRayon = imageRayonService.retrieveAllImagesRayons();
		return imagesRayon;
	}

	//http://localhost:8080/SpringMVC/servlet/get-image-rayon/5	
	@GetMapping("/get-image-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public ImagesRayon getImageRayon(@PathVariable("id") Long imageRayonId) {
		ImagesRayon s = imageRayonService.getImageRayon(imageRayonId);
		return s;
	}

	//http://localhost:8080/SpringMVC/servlet/get-image-rayon/5	
	@GetMapping("/get-image-by-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public List<ImagesRayon> getImageByRayon(@PathVariable("id") Long rayonId) {
		List<ImagesRayon> s = imageRayonService.getImageRayonParRayon(rayonId);
		return s;
	}

	// http://localhost:8080/SpringMVC/servlet/add-image-rayon
	@PostMapping("/add-image-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public ImagesRayon addImageRayon(@RequestBody ImagesRayon s,@PathVariable("id") Long rayonId) {
		ImagesRayon imagesRayon = imageRayonService.addImageRayon(s,rayonId);
		return imagesRayon;
	}

	// http://localhost:8080/SpringMVC/servlet/update-image-rayon/5
	@PutMapping("update-image-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public ImagesRayon updateImagesRayon(@PathVariable("id") Long id, @RequestBody ImagesRayon s) {
		ImagesRayon imagesRayon = imageRayonService.updateImageRayon(s);
		return imagesRayon;
	}

	//http://localhost:8080/SpringMVC/servlet/delete-image-rayon/7
	@DeleteMapping("delete-image-rayon/{id}")
	@ResponseBody
	@CrossOrigin
	public void deleteImagesRayon(@PathVariable("id") Long id) {
		imageRayonService.deleteImageRayon(id);
	}

}
