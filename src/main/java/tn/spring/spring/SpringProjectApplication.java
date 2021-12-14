package tn.spring.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.spring.spring.services.IClient;
import tn.spring.spring.services.IDetailFacture;
import tn.spring.spring.services.IDetailProduit;
import tn.spring.spring.services.IFacture;
import tn.spring.spring.services.IProduit;
import tn.spring.spring.services.IRayon;
import tn.spring.spring.services.IStock;



@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {

	@Autowired
	IProduit produitService;
	@Autowired
	IDetailProduit detailProduitService;
	@Autowired
	IClient clientService;
	@Autowired
	IDetailFacture detailFactureService;
	@Autowired
	IFacture factureService;
	@Autowired
	IRayon rayonService;
	@Autowired
	IStock stockService;
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
