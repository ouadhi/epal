package com.api.service.debarquement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.debarquement.IDebarquementDao;
import com.api.entity.epal.Debarquement;
@Service
public class DebarquementService implements IDebarquementService { 
	
	@Autowired
	private IDebarquementDao  dao ; 
	
	@Override
	public List<Debarquement> all() {
		return dao.AllDebarequemnts();
	}

	@Override
	public List<Debarquement> byEscale(int escale) {
		return dao.byEscale(escale);
	}

	@Override
	public Debarquement byID(int id) {
		return dao.byId(id);
	}

	@Override
	public boolean add(Debarquement debarquement) {
		if (dao.exist(debarquement.getEscale(), debarquement.getCts())) {
			return false ; 
		} else {
			dao.add(debarquement)  ; 
			return true ; 
		}
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public Debarquement byEscalcts(int escale, String cts) {
		
		return  dao.byEscaleId(escale, cts)  ; 
	}

}
