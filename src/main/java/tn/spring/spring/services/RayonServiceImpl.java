package tn.spring.spring.services;

import java.text.ParseException;
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

import tn.spring.spring.entity.ImagesRayon;
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
	public List<Rayon> retrieveAllRayonsSortedASC() {
		List<Rayon> allRayons = rayonRepository.sortASC();
		return allRayons;
	}

	@Override
	public List<Rayon> retrieveAllRayonsSortedDESC() {
		List<Rayon> allRayons = rayonRepository.sortDESC();
		return allRayons;
	}

	@Override
	public Rayon addRayon(Rayon r) {
		// TODO Auto-generated method stub
		Date date = new Date();
		r.setCreatedAt(date);
		r.setUpdatedAt(date);
		r.setDeleteAt(date);
		r.setState(true);
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
		/*Map<Integer,Rayon> map = new HashMap<>();
		List<Rayon> list = rayonRepository.findAll();
		for ( Rayon r : list) {
			map.put( r.getProduits().size(), r);
		}
		Map<Integer,Rayon> treeMap = new TreeMap<>(map);
		List<Rayon> sortedValues = new ArrayList<Rayon>(treeMap.values());
		Collections.reverse(sortedValues);*/
		List<Rayon> sortedValues= rayonRepository.sortByProductsNumber();
		return sortedValues;
	}

	@Override
	public List<Rayon> filterByProductsPrice(Float min, Float max) {
		List<Rayon> list = rayonRepository.filterByProductPrice(min, max);
		return list;
	}

	@Override
	public List<Rayon> retrieveActive() {
		// TODO Auto-generated method stub
		return rayonRepository.findByState(true);
	}

	@Override
	public List<Rayon> retrieveDeleted() {
		// TODO Auto-generated method stub
		return rayonRepository.findByState(false);
	}

	@Override
	public Rayon deleteRayonByState(Long id) {
		Rayon r = rayonRepository.findByIdRayon(id);
		Date date = new Date();
		r.setDeleteAt(date);
		r.setState(false);
		return rayonRepository.save(r);
	}

	@Override
	public int getCreatedNumberLastMonth() {
		// TODO Auto-generated method stub
		return rayonRepository.getCreatedNumberLastMonth();
	}

	@Override
	public int getCreatedNumberLast6Months() {
		// TODO Auto-generated method stub
		return rayonRepository.getCreatedNumberLast6Months();
	}

	@Override
	public int getCreatedNumberLastYear() {
		// TODO Auto-generated method stub
		return rayonRepository.getCreatedNumberLastYear();
	}

	@Override
	public int getCreatedNumberLastWeek() {
		// TODO Auto-generated method stub
		return rayonRepository.getCreatedNumberLastWeek();
	}

	@Override
	public int getDeletedNumberLastMonth() {
		// TODO Auto-generated method stub
		return rayonRepository.getDeleteNumberLastMonth();
	}

	@Override
	public int getDeletedNumberLast6Months() {
		// TODO Auto-generated method stub
		return rayonRepository.getDeleteNumberLast6Months();
	}

	@Override
	public int getDeletedNumberLastYear() {
		// TODO Auto-generated method stub
		return rayonRepository.getDeletedNumberLastYear();
	}

	@Override
	public int getDeletedNumberLastWeek() {
		// TODO Auto-generated method stub
		return rayonRepository.getDeletedNumberLastWeek();
	}

	@Override
	public List<Object> getTopDaysCreated() {
		// TODO Auto-generated method stub
		return rayonRepository.getTopDaysCreated();
	}

	@Override
	public List<Object> getTopMonthsCreated() {
		// TODO Auto-generated method stub
		return rayonRepository.getTopMonthsCrated();
	}

	@Override
	public List<Object> getTopDaysDeleted() {
		// TODO Auto-generated method stub
		return rayonRepository.getTopDaysDeleted();
	}

	@Override
	public List<Object> getTopMonthsDeleted() {
		// TODO Auto-generated method stub
		return rayonRepository.getTopMonthsDeleted();
	}

	@Override
	public Integer getNbCreatedByDates(String d1, String d2) {
		// TODO Auto-generated method stub
	
		return rayonRepository.getNbCreatedByDates(d1, d2);
	}
	@Override
	public Integer getNbDeletededByDates(String d1, String d2) {
		// TODO Auto-generated method stub
	
		return rayonRepository.getNbDeletedByDates(d1, d2);
	}

	
	

}

