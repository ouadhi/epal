package com.api.dao.debarquement;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.epal.Debarquement;

@Transactional
@Repository
public class DebarquelmentDao implements IDebarquementDao{
	
	@Autowired
	private  EntityManager entityManager ; 
	@Override
	public List<Debarquement> AllDebarequemnts() {
		
		String hql  = "FROM Debarquement " ; 
		List<Debarquement> list  = entityManager.createQuery(hql).getResultList();  
		
		return list;
	}

	@Override
	public Debarquement byId(int id) {
		String hql  = "FROM Debarquement  WHERE id =?1 "; 
		Debarquement debarquement  = (Debarquement) entityManager.createQuery(hql)
				.setParameter(1, id)
				.getResultList()
				.stream().
				findFirst()
				.orElse(null);
		
		return  debarquement ; 
	}

	@Override
	public List<Debarquement> byEscale(int escale) {
		String hql  = "FROM Debarquement WHERE escale = ?1" ; 
		@SuppressWarnings("unchecked")
		List<Debarquement> list  = entityManager.createQuery(hql)
				.setParameter(1, escale).
				getResultList();  
		
		return list;
	}

	@Override
	public boolean add(Debarquement debarquement) {
		if (!exist(debarquement.getEscale(), debarquement.getCts())) {
			debarquement.setDate_ajoute(new Date() );
			entityManager.persist(debarquement);
			return true ; 
		} 
		return  false ; 
	}

	@Override
	public void delete(int id) {
		entityManager.remove(byId(id));
	}

	@Override
	public boolean exist(int escale, String cts) {
		String  hql  =  "FROM Debarquement WHERE escale =?1  AND cts  = ?2" ; 
		int  count  =  entityManager.createQuery(hql)
				.setParameter(1, escale)
				.setParameter(2,cts)
				.getResultList()
				.size() ;  
		return count > 0  ?  true :false ;  
	}

	@Override
	public Debarquement byEscaleId(int escale, String cts) {
		String  hql  =  "FROM Debarquement WHERE escale =?1  AND cts  = ?2" ; 
		Debarquement debarquement  =  (Debarquement) entityManager.createQuery(hql)
				.setParameter(1, escale)
				.setParameter(2,cts)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null)  ; 
		
		return   debarquement ;  
	}

}
