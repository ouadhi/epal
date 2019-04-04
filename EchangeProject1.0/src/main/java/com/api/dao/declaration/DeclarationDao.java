package com.api.dao.declaration;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.Article;
import com.api.entity.douane.Declaration;

@Transactional
@Repository
public class DeclarationDao  implements  IDeclarationDao{
     
	@PersistenceContext
	private EntityManager entityManager  ;
	
	@Override
	public List<Declaration> getAll() {
		String hql =  " FROM Declaration WHERE flag = false "  ; 
		List<Declaration> resultList = (List<Declaration>) entityManager.createQuery(hql).getResultList();
		
		return  resultList;
	}

	@Override
	public boolean add(Declaration declaration) {
		if (!existe(declaration.getEscale(), declaration.getNum_manifest(), declaration.getCts())) {
			declaration.setFlag(false);
			entityManager.persist(declaration);
			return true; 
		} 
		return  false ; 
	}

	@Override
	public void update(Declaration declaration) {
		declaration.setFlag(true);
		declaration.setDate_marquage(new Date());;
		entityManager.merge(declaration) ; 
		
	}

	@Override
	public void delete(int idDeclaration) {
	entityManager.remove(byID(idDeclaration));
		
	}

	@Override
	public Declaration byID(Integer idDeclaration) {
		String hql  ="FROM Declaration WHERE id = ?1 AND flag = false"  ;  
		Declaration declaration  = (Declaration)  entityManager.
				createQuery(hql)
				.setParameter(1, idDeclaration)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null); 
		return declaration;
	}

	@Override
	public List<Declaration> byEscale(int escale) {
		String hql  ="FROM Declaration WHERE escale = ?1 AND flag = false"  ;  
		List<Declaration>  liste  =  entityManager.createQuery(hql).setParameter(1, escale).getResultList() ; 
		return liste;
	}

	@Override
	public boolean existe(int escale, int num_manif, String cts) {
		String hql  ="FROM Declaration WHERE escale = ?1 and num_manifest = ?2  and  cts =?3 AND  flag = false"  ;  
		int count  =  entityManager.createQuery(hql)
				.setParameter(1, escale)
				.setParameter(2, num_manif)
				.setParameter(3, cts)
				.getResultList().size(); 
		return count >0  ? true : false ;
	}

	@Override
	public void mark(int idDeclaration) {
		Declaration declaration  =  byID(idDeclaration)  ; 
		declaration.setFlag(true);
		declaration.setDate_marquage(new Date());
		entityManager.merge(declaration);
	}

	@Override
	public List<Declaration> byNumDecl(int numDecl) {
		String hql = "FROM Declaration WHERE num_declaration = ?1 AND flag = false " ;  
		List<Declaration>  liste =  entityManager.createQuery(hql).setParameter(1, numDecl).getResultList() ;  
		return  liste ;  
	}
	
	

}
