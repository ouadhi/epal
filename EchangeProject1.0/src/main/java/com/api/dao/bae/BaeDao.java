package com.api.dao.bae;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.douane.Bae;
import com.api.entity.douane.Manifest;

@Transactional
@Repository
public class BaeDao  implements  IBaeDao  {
	
	@PersistenceContext
	private  EntityManager entityManager  ; 

	@Override
	public List<Bae> getAll() {
		String hql =  "FROM Bae WHERE flag =  false " ;  
		List<Bae>  liste =  entityManager.createQuery(hql).getResultList() ; 
		return  liste ; 
	}

	@Override
	public boolean  add(Bae bae) {
		
		if (!existe(bae.getEscale(), bae.getCts())) {
			entityManager.persist(bae);
			return true; 
		} 
		return false  ; 
	}

	@Override
	public void update(Bae bae) {
		entityManager.persist(bae);
		
	}

	@Override
	public void delete(int idBae) {
		entityManager.remove(byID(idBae));
		
	}

	@Override
	public Bae byID(Integer id) {
		String hql =  "FROM Bae WHERE id = ?1 AND flag =  false " ;
		@SuppressWarnings("unchecked")
		Bae   bae =  (Bae) entityManager.createQuery(hql)
				.setParameter(1, id)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null) ; 
		
		return bae  ;  
	
	}

	@Override
	public List<Bae> byEscale(int escale) {
		String hql =  "FROM Bae WHERE escale = ?1 AND flag =  false " ;  
		List<Bae>  liste =  entityManager.createQuery(hql).setParameter(1, escale).getResultList() ; 
		return  liste ; 
	}

	@Override
	public boolean existe(int escale, String cts) {
		String hql =  "FROM Bae WHERE escale = ?1 AND cts =?2 AND flag =  false " ;  
		int count =  entityManager.createQuery(hql)
				.setParameter(1, escale)
				.setParameter(2, cts).
				getResultList()
				.size(); 
		return  count >0 ? true : false  ; 
	}

	@Override
	public void mark(int idBae) {
		Bae  bae  =  byID(idBae) ;
		if (bae != null ) {
			bae.setFlag(true);
			bae.setDate_marquage(new Date());
			entityManager.merge(bae);
		} 
		
	}


	@Override
	public Bae ByEscaleCts(int escale, String cts) {
		String hql =  "FROM Bae WHERE escale = ?1 AND cts =?2 AND flag =  false " ;  
		Bae bae =  (Bae)   entityManager.createQuery(hql).
				setParameter(1, escale)
				.setParameter(2, cts).
				getResultList()
				.stream()
				.findFirst()
				.orElse(null)  ; 
		
		return bae ; 
	}

}
