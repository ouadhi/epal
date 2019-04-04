package com.api.service.bae;

import java.util.List;

import com.api.entity.douane.Bae;

public interface IBaeService {
		
	List<Bae> getAllBae () ; 
	boolean addBae (Bae bae) ; 
	void delete (int  idBae)  ;  
	void update (Bae bae)  ;  
	
	Bae finById (int idBae)  ;  
    List<Bae> finByEscale (int escale)  ; 
    Bae findByEscaleCts (int escale , String cts ) ; 
    boolean existe ( int escale  ,  String cts  ) ; 
	void mark(int idBae) ;  
	

}
