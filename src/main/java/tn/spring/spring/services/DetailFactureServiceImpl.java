package tn.spring.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.DetailFacture;
import tn.spring.spring.repository.DetailFactureRepository;

@Service
public class DetailFactureServiceImpl implements IDetailFacture{

	@Autowired
	DetailFactureRepository detailFactureRepositry;
	
	@Override
	public List<DetailFacture> retrieveAllDetailsFactures() {
		List<DetailFacture> allDetailFactures = detailFactureRepositry.findAll();
		return allDetailFactures;
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture detailF) {
		detailFactureRepositry.save(detailF);
		return detailF;
	}

	@Override
	public void deleteDetailFacture(Long id) {
		detailFactureRepositry.deleteByIdDetailFacture(id);
		
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture f) {
		
		return detailFactureRepositry.save(f);
	}

	@Override
	public DetailFacture retrieveDetailFacture(Long id) {
		// TODO Auto-generated method stub
		return detailFactureRepositry.findByIdDetailFacture(id);
	}

}
