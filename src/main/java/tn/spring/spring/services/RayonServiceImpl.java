package tn.spring.spring.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.Produit;
import tn.spring.spring.entity.Rayon;
import tn.spring.spring.repository.RayonRepository;

@Service
public class RayonServiceImpl implements IRayon {

	@Autowired
	RayonRepository rayonRepository;

	@Override
	public List<Rayon> retrieveAllRayons() {
		List<Rayon> allRayons = rayonRepository.findAll();
		return allRayons;
	}
	
	@Override
	public List<Rayon> retrieveAllRayonsSorted() {
		List<Rayon> allRayons = rayonRepository.findAll(Sort.by(Sort.Direction.ASC, "libelleRayon"));
		return allRayons;
	}

	@Override
	public Rayon addRayon(Rayon r) {
		// TODO Auto-generated method stub
		Date date = new Date();
		r.setCreatedAt(date);
		r.setState(1);
		return rayonRepository.save(r);
	}

	@Override
	public void deleteRayon(Long id) {
		rayonRepository.deleteByIdRayon(id);
	}
	
	

	@Override
	public Rayon updateRayon(Rayon r) {
		Date date = new Date();
		r.setUpdatedAt(date);
		return rayonRepository.save(r);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		return rayonRepository.findByIdRayon(id);
	}
	
	@Override
	public List<Rayon> rechercheAvancee(String string){
		List<Rayon> rechList = rayonRepository.rech(string);
		return rechList;
	}

	@Override
	public List<Rayon> retrieveAllRayonSortedByProductsNumber() {
		Map<Integer,Rayon> map = new HashMap<>();
		List<Rayon> list = rayonRepository.findAll();
		for ( Rayon r : list) {
			map.put( r.getProduits().size(), r);
		}
		Map<Integer,Rayon> treeMap = new TreeMap<>(map);
		List<Rayon> sortedValues = new ArrayList<Rayon>(treeMap.values());
		Collections.reverse(sortedValues);
		return sortedValues;
	}

	@Override
	public List<Rayon> filterByProductsPrice(float min, float max) {
		List<Rayon> list = rayonRepository.findAll();
		for (Rayon r : list) {
			List<Produit> listP = r.getProduits();
			listP.stream().filter(p -> p.getPrixUnitaire()>=min && p.getPrixUnitaire()<=max).collect(Collectors.toList());
		}
		return list;
	}

	@Override
	public List<Rayon> retrieveActive() {
		// TODO Auto-generated method stub
		return rayonRepository.findByState(1L);
	}

	@Override
	public List<Rayon> retrieveDeleted() {
		// TODO Auto-generated method stub
		return rayonRepository.findByState(0L);
	}

	@Override
	public Rayon deleteRayonByState(Long id) {
		Rayon r = rayonRepository.findByIdRayon(id);
		r.setState(0);
		return r;
	}
}

