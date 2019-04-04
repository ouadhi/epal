package com.api.service.declaration;

import java.util.List;

import com.api.entity.douane.Declaration;


public interface IDeclarationService {

	List<Declaration> getAllDeclarations() ; 
	Declaration getDeclarationByID(int idDeclaration ) ; 
	List<Declaration>getDeclarataionByEscal (int escale) ; 
	boolean addDeclaration (Declaration declaration)  ;  
	void deleteDeclaration (int  idDeclaration) ; 
	boolean DeclarationExsite (Declaration declaration ) ; 
	void markDeclaration (int idDeclaration) ; 
	List<Declaration> getdeclarationByNumDecl(int numDeclaration) ; 
	
}
