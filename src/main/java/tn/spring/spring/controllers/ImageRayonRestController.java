package tn.spring.spring.controllers;

import java.util.List;
import java.nio.file.Files;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import tn.spring.spring.repository.RayonRepository;
import tn.spring.spring.services.IImagesRayon;
import tn.spring.spring.services.IRayon;

@RestController
public class ImageRayonRestController {
	@Autowired
	IImagesRayon imageRayonService;
	
	@Autowired
	IRayon rayonService;
	
	private final Path root = Paths.get("C:\\Users\\Hamza\\Desktop\\projet-angular-ekher\\GestionMagasin-Spring-Angular-hamza\\src\\assets\\images");

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
	public ImagesRayon addImageRayon(@RequestParam("file") MultipartFile fileUpload,@PathVariable("id") Long rayonId) throws IOException {
	   // Files.createDirectory(root);
		ImagesRayon uploadFile = new ImagesRayon();
        uploadFile.setImageRayon("./assets/images/"+fileUpload.getOriginalFilename());
        uploadFile.setRayon(rayonService.retrieveRayon(rayonId));
        //Files.write("./assets/images/"+fileUpload.getOriginalFilename(), fileUpload.getBytes());
        Files.copy(fileUpload.getInputStream(),this.root.resolve(fileUpload.getOriginalFilename()));

        ImagesRayon imagesRayon = imageRayonService.addImageRayon(uploadFile,rayonId);
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
