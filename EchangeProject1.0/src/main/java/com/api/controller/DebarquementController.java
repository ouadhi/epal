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

import com.api.entity.epal.Debarquement;
import com.api.service.debarquement.IDebarquementService;

@Controller
@RequestMapping("debarquement")
public class DebarquementController {
	
	@Autowired
	private IDebarquementService  service  ; 
	
	@GetMapping("")
	public ResponseEntity<List<Debarquement>> startApplication () {
		return new ResponseEntity<List<Debarquement>>(service.all(),HttpStatus.OK)  ; 
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Debarquement> getByID(@PathVariable("id") Integer id ) {
        Debarquement  debarquement  = service.byID(id)  ; 
		return new ResponseEntity<Debarquement>(debarquement, HttpStatus.OK);
	}
	
	@GetMapping("/escale/{escale}")
	public ResponseEntity<List<Debarquement>> getByEscale(@PathVariable("escale") int escale ) {
		List<Debarquement>  liste = service.byEscale(escale)  ;   
		return new ResponseEntity<List<Debarquement>>(liste, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Void> add (@RequestBody Debarquement debarquement, UriComponentsBuilder builder){
		boolean  flag   = service.add(debarquement)  ;  
		
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT) ; 
		} 
		
		HttpHeaders  headers = new HttpHeaders()  ;  
		Map<String,String> map=new HashMap<String,String>();
		 map.put("escale", Integer.toString(debarquement.getEscale())) ; 
		 map.put("cts", debarquement.getCts())  ;  
		 
		headers.setLocation(builder.path("debarquement/{escale}/{cts}").buildAndExpand(map).toUri());
		return new ResponseEntity<Void>(headers , HttpStatus.CREATED) ; 
	}
	
	@GetMapping("/{escale}/{cts}")
	public ResponseEntity<Debarquement> getByID(@PathVariable("escale") Integer escale ,  @PathVariable("cts") String  cts  ) {
        Debarquement  debarquement  = service.byEscalcts(escale, cts)  ; 
		return new ResponseEntity<Debarquement>(debarquement, HttpStatus.OK);
	}
	
}
