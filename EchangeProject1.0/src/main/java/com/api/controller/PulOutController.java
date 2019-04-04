package com.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.entity.epal.SortiePhysique;
import com.api.service.sortiePhysique.ISortiePhysiqueService;


@Controller
@RequestMapping("pullout")
public class PulOutController {
	@Autowired
	private ISortiePhysiqueService  service  ; 
	
	@GetMapping("")
	public ResponseEntity<List<SortiePhysique>> startApplication () {
		return new ResponseEntity<List<SortiePhysique>>(service.all(),HttpStatus.OK)  ; 
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<SortiePhysique> getByID(@PathVariable("id") Integer id ) {
        SortiePhysique  sortiePhysique  = service.byID(id)  ; 
		return new ResponseEntity<SortiePhysique>(sortiePhysique, HttpStatus.OK);
	}
	
	@GetMapping("/escale/{escale}")
	public ResponseEntity<List<SortiePhysique>> getByEscale(@PathVariable("escale") int escale ) {
		List<SortiePhysique>  liste = service.byEscale(escale)  ;   
		return new ResponseEntity<List<SortiePhysique>>(liste, HttpStatus.OK);
	} 
	
	@PostMapping("")
	public ResponseEntity<Void> add (@RequestBody SortiePhysique  sortiePhysique, UriComponentsBuilder builder){
		boolean  flag   = service.add(sortiePhysique)  ;  
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT) ; 
		} 
		Map<String, String> map  = new  HashMap<>(); 
		map.put("escale", Integer.toString(sortiePhysique.getEscale()))  ;
		map.put("cts",sortiePhysique.getCts()) ; 
		HttpHeaders  headers = new HttpHeaders()  ;  
		headers.setLocation(builder.path("pullout/{escale}/{cts}").buildAndExpand(map).toUri());
		return new ResponseEntity<Void>(headers , HttpStatus.CREATED) ; 
	}
	
	
	@GetMapping("/{escale}/{cts}")
	public ResponseEntity<SortiePhysique> getByEscaleCts(@PathVariable("escale") int escale, @PathVariable("cts") String cts  ) {
		 SortiePhysique  physique  =  service.byEscleCts(escale, cts) ;   
		return new ResponseEntity<SortiePhysique>(physique, HttpStatus.OK);
	}
	
}
