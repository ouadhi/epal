package com.api.service.sortiePhysique;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.sortiePhysique.ISortiePhysiqueDoa;
import com.api.entity.epal.SortiePhysique;

@Service
public class SortiePhysiqueService implements ISortiePhysiqueService {
	@Autowired
	private ISortiePhysiqueDoa  dao  ; 
	
	@Override
	public List<SortiePhysique> all() {
	
		return dao.Allpullout() ; 
	}

	@Override
	public List<SortiePhysique> byEscale(int escale) {
		
		return dao.byEscale(escale) ; 
	}

	@Override
	public SortiePhysique byID(int id) {
		
		return dao.byId(id)  ; 
	}

	@Override
	public boolean add(SortiePhysique sortiePhysique) {
		 return  dao.add(sortiePhysique);
		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public SortiePhysique byEscleCts(int escale, String cts) {
		
		return dao.byEscaleCts(escale, cts);
	}

}
