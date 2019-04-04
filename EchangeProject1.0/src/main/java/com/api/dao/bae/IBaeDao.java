package com.api.dao.bae;

import java.util.List;

import com.api.entity.douane.Bae;
import com.api.entity.douane.Manifest;

public interface IBaeDao {
	List<Bae> getAll() ; 
    boolean  add(Bae bae ) ; 
    void update(Bae bae)  ; 
    void delete ( int idBae)  ;  
    
    Bae byID  (Integer id) ;  
    List<Bae> byEscale (int escale)  ; 
    boolean existe ( int escale  ,  String cts  ) ; 
    Bae ByEscaleCts(int escale  ,  String cts )  ; 
    
    void mark(int idBae) ;  
}
