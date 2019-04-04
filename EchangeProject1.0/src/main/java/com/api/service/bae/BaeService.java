package com.api.service.bae;

import java.util.List;

import org.hibernate.engine.jdbc.batch.spi.BatchObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.api.dao.bae.IBaeDao;
import com.api.entity.douane.Bae;
@Service
public class BaeService  implements  IBaeService {
    
	@Autowired
	private  IBaeDao baeDao;
	@Override
	public List<Bae> getAllBae() {
		
		return baeDao.getAll();
	}

	@Override
	public boolean addBae(Bae bae) {
		
		return baeDao.add(bae) ; 
	}

	@Override
	public void delete(int idBae) {
		baeDao.delete(idBae);
		
	}

	@Override
	public void update(Bae bae) {
		baeDao.update(bae);
		
	}

	@Override
	public Bae finById(int idBae) {
		return baeDao.byID(idBae) ;  
	}

	@Override
	public List<Bae> finByEscale(int escale) {
		return baeDao.byEscale(escale);
	}

	@Override
	public boolean existe(int escale, String cts) {
		return baeDao.existe(escale, cts);
	}

	@Override
	public void mark(int idBae) {
		baeDao.mark(idBae);
		
	}

	@Override
	public Bae findByEscaleCts(int escale, String cts) {
		
		return  baeDao.ByEscaleCts(escale, cts) ; 
	}

}
