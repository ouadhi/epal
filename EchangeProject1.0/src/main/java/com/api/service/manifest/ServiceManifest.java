package com.api.service.manifest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.manifest.IManifestDao;
import com.api.entity.douane.Manifest;

@Service
public class ServiceManifest  implements  IServiceManifest {
	
	@Autowired(required= false )
	IManifestDao manifestDao ; 

	@Override
	public List<Manifest> getAllManifests() {
		return manifestDao.getAll() ; 
	}

	@Override
	public Manifest getManifestByID(int idManifest) {
		return manifestDao.byID(idManifest);  
	}

	@Override
	public List<Manifest> getManifestByEscal(int escale) {
		
		return manifestDao.byEscale(escale)  ; 
	}

	@Override
	public boolean addManifest(Manifest manifest) {
		if (manifesExsite(manifest)) {
			return false ;  
		} else {
             manifestDao.add(manifest);
             return  true ;  
		}
	}

	@Override
	public void deleteManifest(  int idManifest) {
		manifestDao.delete(idManifest);
		
	}

	@Override
	public boolean manifesExsite(Manifest manifest) {
		
		return manifestDao.existe(manifest.getEscale(), manifest.getNum_manifest(),manifest.getCts())  ;  
		
	}

	@Override
	public void markManifest(int idmanifest) {
		manifestDao.mark(idmanifest);
	}

	

}
