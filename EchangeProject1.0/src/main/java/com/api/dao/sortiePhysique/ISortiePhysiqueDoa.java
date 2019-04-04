package com.api.dao.sortiePhysique;

import java.util.List;

import com.api.entity.epal.SortiePhysique;

public interface ISortiePhysiqueDoa {
	List<SortiePhysique> Allpullout() ; 
	SortiePhysique byId(int id  ) ; 
	List<SortiePhysique> byEscale (int escale )  ;   
	boolean add(SortiePhysique debarquement ) ;
	void delete(int id) ;
	boolean  exist (int  escale , String cts); 
	SortiePhysique  byEscaleCts (int escale , String Cts )   ; 
}
