package com.api.service.debarquement;

import java.util.List;

import com.api.entity.epal.Debarquement;

public interface IDebarquementService {
	
	List<Debarquement> all() ; 
	List<Debarquement> byEscale( int escale ) ;
	Debarquement byID (int id) ; 
	boolean add (Debarquement debarquement) ; 
	void delete(int id) ; 
	Debarquement   byEscalcts ( int escale ,  String cts )  ; 

}
