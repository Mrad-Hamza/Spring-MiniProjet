package tn.spring.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.ImagesRayon;
import tn.spring.spring.entity.Rayon;

import tn.spring.spring.repository.ImagesRayonRepository;
import tn.spring.spring.repository.RayonRepository;

@Service
public class ImagesRayonServiceImpl implements IImagesRayon {

	@Autowired
	ImagesRayonRepository imagesRayonRepository;
	
	@Autowired 
	RayonRepository rayonRepository;
	
	@Override
	public List<ImagesRayon> retrieveAllImagesRayons() {
		return imagesRayonRepository.findAll();
	}

	@Override
	public ImagesRayon addImageRayon(ImagesRayon imageR, Long idRayon) {
		Rayon r = rayonRepository.findByIdRayon(idRayon);
		imageR.setRayon(r);
		imagesRayonRepository.save(imageR);
		return null;
	}

	@Override
	public void deleteImageRayon(Long id) {
		imagesRayonRepository.deleteByIdImageRayon(id);
	}

	@Override
	public ImagesRayon updateImageRayon(ImagesRayon r) {
		imagesRayonRepository.save(r);
		return null;
	}

	@Override
	public ImagesRayon getImageRayon(Long id) {
		imagesRayonRepository.findByIdImageRayon(id);
		return null;
	}
	
	@Override
	public List<ImagesRayon> getImageRayonParRayon(Long id) {
		Rayon r = rayonRepository.findByIdRayon(id);
		return imagesRayonRepository.findByRayon(r);
		
	}
	


}
