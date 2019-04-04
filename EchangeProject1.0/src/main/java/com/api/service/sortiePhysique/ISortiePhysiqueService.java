package com.api.service.sortiePhysique;

import java.util.List;


import com.api.entity.epal.SortiePhysique;


public interface ISortiePhysiqueService {
	
	List<SortiePhysique> all() ; 
	List<SortiePhysique> byEscale( int escale ) ;
	SortiePhysique byID (int id) ; 
	boolean add (SortiePhysique sortiePhysique ) ; 
	void delete(int id) ; 
	SortiePhysique  byEscleCts (int escale, String  cts)  ; 

}
