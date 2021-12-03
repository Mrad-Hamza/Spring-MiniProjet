package tn.spring.spring.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.spring.spring.entity.ImagesRayon;

public interface IImagesRayon {

	List<ImagesRayon> retrieveAllImagesRayons();
	
	ImagesRayon getImageRayon(Long id);

	ImagesRayon addImageRayon(ImagesRayon r, Long idRayon);

	@Transactional
	void deleteImageRayon(Long id);

	ImagesRayon updateImageRayon(ImagesRayon r);
	
	List<ImagesRayon> getImageRayonParRayon(Long id);
}
