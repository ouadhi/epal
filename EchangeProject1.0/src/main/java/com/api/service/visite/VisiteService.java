package com.api.service.visite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.parcvisite.IParcVisiteDao;
import com.api.entity.epal.ParcVisite;

@Service
public class VisiteService  implements  IVisiteService {
	
	@Autowired
	private  IParcVisiteDao  dao ; 
	
	@Override
	public List<ParcVisite> all() {
		
		return dao.allVisites();
	}

	@Override
	public List<ParcVisite> byEscale(int escale) {
		
		return dao.byEscale(escale);
	}

	@Override
	public ParcVisite byID(int id) {
		return dao.byId(id);
	}

	@Override
	public boolean add(ParcVisite parcVisite) {
		return dao.add(parcVisite) ; 
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public ParcVisite byCts(int escale ,String cts) {
		
		return dao.byCts(escale, cts);
	}

}
