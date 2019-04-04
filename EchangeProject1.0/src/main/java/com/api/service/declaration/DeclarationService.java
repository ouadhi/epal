package com.api.service.declaration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.declaration.IDeclarationDao;
import com.api.entity.douane.Declaration;
import com.api.entity.douane.Manifest;

@Service
public class DeclarationService  implements  IDeclarationService {
	
	@Autowired
	private   IDeclarationDao dao  ;  
	@Override
	public List<Declaration> getAllDeclarations() {
		return dao.getAll();
	}

	@Override
	public Declaration getDeclarationByID(int idDeclaration) {
		return dao.byID(idDeclaration);
	}

	@Override
	public List<Declaration> getDeclarataionByEscal(int escale) {
		return dao.byEscale(escale);
	}

	@Override
	public boolean addDeclaration(Declaration declaration) {
		return  dao.add(declaration);
	}

	@Override
	public void deleteDeclaration(int idDeclaration) {
		
		dao.delete(idDeclaration);
	}

	@Override
	public boolean DeclarationExsite(Declaration declaration) {
		
		return dao.existe(declaration.getEscale(), declaration.getNum_manifest(), declaration.getCts()) ; 
	}

	@Override
	public void markDeclaration(int idDeclaration) {
	     dao.mark(idDeclaration);
	}

	@Override
	public List<Declaration> getdeclarationByNumDecl(int numDeclaration) {
		return dao.byNumDecl(numDeclaration) ;
	}

}
