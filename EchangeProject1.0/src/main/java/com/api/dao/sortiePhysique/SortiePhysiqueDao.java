package com.api.dao.sortiePhysique;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.epal.SortiePhysique;

@Transactional
@Repository
public class SortiePhysiqueDao  implements  ISortiePhysiqueDoa  {
	@PersistenceContext
	private EntityManager entityManager ; 
	
	@Override
	public List<SortiePhysique> Allpullout() {
		String hql  =  "FROM SortiePhysique " ; 
		List<SortiePhysique> liste = entityManager.createQuery(hql).getResultList()  ; 
		return liste;
	}

	@Override
	public SortiePhysique byId(int id) {
		String hql =  "FROM SortiePhysique WHERE id = ?1" ; 
		SortiePhysique physique = (SortiePhysique)  entityManager.createQuery(hql).setParameter(1, id).
				getResultList()
				.stream()
				.findFirst()
				.orElse(null); 
				
		return physique;
	}

	@Override
	public List<SortiePhysique> byEscale(int escale) {
		String hql  =  "FROM SortiePhysique WHERE escale =?1 " ; 
		List<SortiePhysique> liste = entityManager.createQuery(hql).setParameter(1, escale).getResultList()  ; 
		return liste;
	}

	@Override
	public boolean add(SortiePhysique debarquement) {
		if (!exist(debarquement.getEscale(), debarquement.getCts())) {
			debarquement.setDate_ajoute(new Date());
			entityManager.persist(debarquement);
			return  true ; 
		} 
		return false  ;
	}

	@Override
	public void delete(int id) {
		entityManager.remove(byId(id));
		
	}

	@Override
	public boolean exist(int escale, String cts) {
		String hql =  "FROM SortiePhysique WHERE escale =?1 AND  cts =?2" ; 
		int count = entityManager.createQuery(hql)
				.setParameter(1, escale)
				.setParameter(2, cts)
				.getResultList().size() ;    
		return  count>0 ? true  : false ;
	}

	@Override
	public SortiePhysique byEscaleCts(int escale, String cts) {
		String hql =  "FROM SortiePhysique WHERE escale =?1 AND  cts =?2" ; 
		SortiePhysique  physique = (SortiePhysique) entityManager.createQuery(hql)
				.setParameter(1, escale)
				.setParameter(2, cts)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null)  ;  
		return  physique ; 
	}

}
