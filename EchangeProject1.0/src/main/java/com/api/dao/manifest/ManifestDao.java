package com.api.dao.manifest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.douane.Manifest;


@Transactional
@Repository
public class ManifestDao implements  IManifestDao{
	  
	@PersistenceContext
	private EntityManager entityManager  ; 


	@Override
	public List<Manifest> getAll() {
		String hql = "FROM Manifest WHERE  flag = false" ; 
		List<Manifest> liste  = entityManager.createQuery(hql).getResultList() ; 
		return  liste;
	}

	@Override
	public void add(Manifest manifest) {
		manifest.setDate_marquage(new Date());
		manifest.setFlag(false);
		entityManager.persist(manifest);
	}

	@Override
	public void update(Manifest manifest) {
		entityManager.persist(manifest);
	}

	@Override
	public void delete(int idManifest) {
		entityManager.remove(byID(idManifest));
		
	}

	@Override
	public Manifest byID(Integer id) {
		String hql = "FROM Manifest WHERE id = ?1 AND  flag = false " ; 
		Manifest  manifest = (Manifest) entityManager.createQuery(hql)
				.setParameter(1, id)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
		
		return  manifest  ; 
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Manifest> byEscale(int escale) {
		String hql = "FROM Manifest WHERE escale = ?1 AND  flag = false " ; 
	     
		return entityManager.createQuery(hql).setParameter(1, escale).getResultList();    
		
	}

	@Override
	public void mark(int idManifest) {
		
		Manifest  manifest  = byID(idManifest)  ;  
		manifest.setFlag(true);
		manifest.setDate_marquage(new Date());
		
		entityManager.merge(manifest);
	}

	@Override
	public boolean existe(int escale, int num_manif, String cts) {
		String hql = "FROM Manifest WHERE escale = ?1 AND num_manifest = ?2 AND  cts = ?3 " ; 
	     
		int count =  entityManager.createQuery(hql).setParameter(1, escale).
				setParameter(2, num_manif)
				.setParameter(3, cts)
				.getResultList().size() ;
		System.out.println(count);
		
		return  count > 0 ? true : false ; 
		
	}
	

}
