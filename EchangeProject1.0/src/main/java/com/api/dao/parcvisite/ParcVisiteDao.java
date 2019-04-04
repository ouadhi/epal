
package com.api.dao.parcvisite;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.epal.ParcVisite;

@Transactional
@Repository
public class ParcVisiteDao implements  IParcVisiteDao{
	
	@PersistenceContext
	private EntityManager entityManager ; 
	
	@Override
	public List<ParcVisite> allVisites() {
		String hql = "FROM ParcVisite"; 
		List<ParcVisite> liste = entityManager.createQuery(hql).getResultList() ; 
		return liste;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ParcVisite byId(int id) {
		String hql = "FROM ParcVisite WHERE id = ?1"; 
		ParcVisite parcVisite = null ; 
		parcVisite = (ParcVisite) entityManager.createQuery(hql)
				.setParameter(1, id)
				.getResultList().stream().findFirst().orElse(null) ; 
		
		return parcVisite;
	}

	@Override
	public List<ParcVisite> byEscale(int escale) {
		
		String hql = "FROM ParcVisite WHERE escale = ?1"; 
		@SuppressWarnings("unchecked")
		List<ParcVisite> liste =  entityManager.createQuery(hql)
				.setParameter(1, escale)
				.getResultList(); 
		
		return liste ;
	}

	@Override
	public boolean add(ParcVisite parcVisite) {
		if (!exist(parcVisite.getEscale(), parcVisite.getCts())) {
			parcVisite.setDate_ajoute(new Date());
			entityManager.persist(parcVisite);
			return  true ; 
		} else {
			return false ;
		}
	}

	@Override
	public void delete(int id) {
		entityManager.remove(byId(id));
		
	}

	@Override
	public boolean exist(int escale, String cts) {
		String  hql  =  "FROM ParcVisite WHERE escale =?1  AND cts  = ?2" ; 
		int  count  =  entityManager.createQuery(hql)
				.setParameter(1, escale)
				.setParameter(2,cts)
				.getResultList().size() ;  
		return count>0  ?  true :false ;  
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ParcVisite byCts(int escale , String cts) {
		String hql = "FROM ParcVisite WHERE cts = ?1 and escale=  ?2"; 
		ParcVisite parcVisite = null ; 
		parcVisite = (ParcVisite) entityManager.createQuery(hql)
				.setParameter(1, cts)
				.setParameter(2, escale)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null) ; 
		
		return parcVisite;
	}

	

}
