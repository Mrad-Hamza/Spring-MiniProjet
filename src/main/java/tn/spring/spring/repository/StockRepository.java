package tn.spring.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	public Stock save(Stock s);

	public Stock findByIdStock(Long id);

	public void deleteByIdStock(Long id);

}
