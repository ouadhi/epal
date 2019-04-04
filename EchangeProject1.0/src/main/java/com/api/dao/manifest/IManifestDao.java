package com.api.dao.manifest;

import java.util.List;

import com.api.entity.douane.Manifest;

public interface IManifestDao {
	List<Manifest> getAll() ; 
    void add(Manifest manifest ) ; 
    void update(Manifest manifest)  ; 
    void delete ( int idManifest)  ;  
    Manifest byID  (Integer id) ;  
    List<Manifest> byEscale (int escale)  ; 
    boolean existe ( int escale  ,  int  num_manif , String cts  ) ; 
    void mark(int idManifest) ;  
}
