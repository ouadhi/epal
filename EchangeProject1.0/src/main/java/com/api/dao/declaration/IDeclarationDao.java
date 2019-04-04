package com.api.dao.declaration;

import java.util.List;

import com.api.entity.douane.Declaration;
import com.api.entity.douane.Manifest;

public interface IDeclarationDao {
	List<Declaration> getAll() ; 
    boolean add(Declaration declaration ) ; 
    void update(Declaration declaration)  ; 
    void delete ( int idDeclaration)  ;  
    Declaration byID  (Integer idDeclaration) ;  
    List<Declaration> byEscale (int escale)  ; 
    boolean existe ( int escale  ,  int  num_manif , String cts  ) ; 
    List<Declaration> byNumDecl(int numDecl ) ; 
    void mark(int idDeclration) ;
}
