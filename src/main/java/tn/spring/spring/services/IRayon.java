package tn.spring.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.spring.spring.entity.ImagesRayon;
import tn.spring.spring.entity.Rayon;

public interface IRayon {
	List<Rayon> retrieveAllRayons();

	Rayon addRayon(Rayon r);

	@Transactional
	void deleteRayon(Long id);

	Rayon deleteRayonByState(Long id);

	Rayon updateRayon(Rayon r);

	Rayon retrieveRayon(Long id);

	List<Rayon> rechercheAvancee(String string);

	List<Rayon> retrieveAllRayonsSortedASC();

	List<Rayon> retrieveAllRayonsSortedDESC();


	List<Rayon> retrieveAllRayonSortedByProductsNumber();

	List<Rayon> filterByProductsPrice(Float min, Float max);

	List<Rayon> retrieveActive();

	List<Rayon> retrieveDeleted();


	// Statistiques Part 1
	int getCreatedNumberLastMonth();

	int getCreatedNumberLast6Months();

	int getCreatedNumberLastYear();

	int getCreatedNumberLastWeek();

	int getDeletedNumberLastMonth();

	int getDeletedNumberLast6Months();

	int getDeletedNumberLastYear();

	int getDeletedNumberLastWeek();

	// Statistiques Part 2
	List<Object> getTopDaysCreated();
	List<Object> getTopMonthsCreated();
	List<Object> getTopDaysDeleted();
	List<Object> getTopMonthsDeleted();
	
	// Statistiques Part 3
	Integer getNbCreatedByDates(String d1, String d2);
	Integer getNbDeletededByDates(String d1, String d2);


}
