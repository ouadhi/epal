package com.api.service.visite;

import java.util.List;

import com.api.entity.epal.ParcVisite;


public interface IVisiteService {
	List<ParcVisite> all() ; 
	List<ParcVisite> byEscale( int escale ) ;
	ParcVisite byID (int id) ; 
	boolean add (ParcVisite parcVisite ) ; 
	void delete(int id) ; 
	ParcVisite byCts (int escale , String cts) ;  
}
