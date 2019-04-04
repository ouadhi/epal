package com.api.dao.parcvisite;

import java.util.List;

import com.api.entity.epal.Debarquement;
import com.api.entity.epal.ParcVisite;

public interface IParcVisiteDao {
	List<ParcVisite> allVisites() ; 
	ParcVisite byId(int id  ) ; 
	List<ParcVisite> byEscale (int escale )  ;   
	ParcVisite byCts( int escale  , String cts  ) ; 
	boolean add(ParcVisite parcVisite ) ;
	void delete(int id) ;
	boolean  exist (int  escale , String cts); 
}
