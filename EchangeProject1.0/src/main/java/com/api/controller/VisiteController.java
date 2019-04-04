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

import com.api.entity.epal.ParcVisite;
import com.api.service.visite.IVisiteService;

@Controller
@RequestMapping("visite")
public class VisiteController {
	
	@Autowired
	private IVisiteService  service  ; 
	
	@GetMapping("")
	public ResponseEntity<List<ParcVisite>> startApplication () {
		return new ResponseEntity<List<ParcVisite>>(service.all(),HttpStatus.OK)  ; 
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ParcVisite> getByID(@PathVariable("id") Integer id ) {
        ParcVisite  parcVisite  = service.byID(id)  ; 
		return new ResponseEntity<ParcVisite>(parcVisite, HttpStatus.OK);
	}
	
	@GetMapping("/escale/{escale}")
	public ResponseEntity<List<ParcVisite>> getByEscale(@PathVariable("escale") int escale ) {
		List<ParcVisite>  liste = service.byEscale(escale)  ;   
		return new ResponseEntity<List<ParcVisite>>(liste, HttpStatus.OK);
	}
	
	@GetMapping("/{escale}/{cts}")
	public ResponseEntity<ParcVisite> getByEscaleCts(@PathVariable("escale") int escale  , @PathVariable("cts") String cts) {
		ParcVisite  liste = service.byCts(escale, cts) ;  
		return new ResponseEntity<ParcVisite>(liste, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Void> add (@RequestBody ParcVisite parcVisite, UriComponentsBuilder builder){
		boolean  flag   = service.add(parcVisite)  ;  
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT) ; 
		} 
		 
		Map<String,String> map=new HashMap<String,String>();
		 map.put("escale", Integer.toString(parcVisite.getEscale())) ; 
		 map.put("cts",parcVisite.getCts())  ;    
		
		HttpHeaders  headers = new HttpHeaders()  ;  
		headers.setLocation(builder.path("visite/{escale}/{cts}").buildAndExpand(map).toUri());
		return new ResponseEntity<Void>(headers , HttpStatus.CREATED) ; 
	}

}
