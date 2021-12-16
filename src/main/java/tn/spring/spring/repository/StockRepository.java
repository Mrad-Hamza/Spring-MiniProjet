package tn.spring.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.spring.spring.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	
	public Stock save(Stock s);

	public Stock findByIdStock(Long id);

	public void deleteByIdStock(Long id);
	
	@Query(value="select * from stock s where s.libelle_stock=:libelle", nativeQuery=true)
	public Stock searchStockByName(@Param("libelle") String libelle);
	
	@Query(value="select * from stock s where s.qte_stock=:qte", nativeQuery=true)
	public List<Stock> searchStockByQte(@Param("qte") int qte);
	
	@Query(value="select * from stock s where s.qte_min > s.qte_stock", nativeQuery=true)
	public List<Stock> getStockByStatus();
	
	@Query(value="select * from stock s where s.state=1", nativeQuery=true)
	public List<Stock> getActiveStocks();
	
	@Query(value="select * from stock s where s.state=0", nativeQuery=true)
	public List<Stock> getPassiveStocks();
	
	/*@Query(value="select count(*) as nbre_stock,DATE_FORMAT(created_date,'%d/%m/%Y) as created_date from stock GROUP BY DATE_FORMAT(created_by,'%d/%m/%Y)", nativeQuery=true)
	public List<?> getnbreStocksbyDate();*/
	
	@Query(value="select count(*) as nbre_stock, state from stock group BY state", nativeQuery=true)
	public List<?> getnbreStocksbystate();
	
	@Query(value="select * from stock s where s.state=1 ORDER by s.qte_stock DESC", nativeQuery=true)
	public List<Stock> sortStocksByQte();
	
	@Query(value="select * from stock s where s.state=1 ORDER by s.libelle_stock DESC", nativeQuery=true)
	public List<Stock> sortStocksByLibelle();
	
	@Query(value="SELECT * FROM Stock WHERE libelle_stock LIKE %:mot% and state=1", nativeQuery=true)
	public List<Stock> searchAdvancedStocks(@Param("mot") String mot);
}
