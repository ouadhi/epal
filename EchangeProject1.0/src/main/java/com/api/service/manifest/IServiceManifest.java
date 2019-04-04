package com.api.service.manifest;

import java.util.List;

import com.api.entity.douane.Manifest;

public interface IServiceManifest {
	
	List<Manifest> getAllManifests () ; 
	Manifest getManifestByID(int idManifest) ; 
	List<Manifest>getManifestByEscal (int escale) ; 
	boolean addManifest (Manifest manifest)  ;  
	void deleteManifest (int  idManifest) ; 
	boolean manifesExsite (Manifest manifest) ; 
	void markManifest (int idmanifest) ; 
	
	
}
