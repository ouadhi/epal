package com.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.entity.douane.Bae;
import com.api.service.bae.IBaeService;


@Controller
@RequestMapping("bae")
public class BaeController {
	
	@Autowired
	private IBaeService baeService  ;  
	
	@GetMapping("")
	public ResponseEntity<List<Bae>> startApplication () {
		return new ResponseEntity<List<Bae>>(baeService.getAllBae(),HttpStatus.OK)  ; 
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Bae> getBaeByID(@PathVariable("id") Integer id ) {
        Bae bae  = baeService.finById(id)  ;  
		return new ResponseEntity<Bae>(bae, HttpStatus.OK);
	}
	
	@GetMapping("/escale/{escale}")
	public ResponseEntity<List<Bae>> getBaeByEscale(@PathVariable("escale") int escale ) {
		List<Bae>  liste = baeService.finByEscale(escale)  ;   
		return new ResponseEntity<List<Bae>>(liste, HttpStatus.OK);
	}
	
	
	
	@PostMapping("")
	public ResponseEntity<Void> addBae (@RequestBody Bae bae , UriComponentsBuilder builder){
		boolean  flag   =  baeService.addBae(bae); 
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT) ; 
		} 
		
		Map<String , String >   map   = new HashMap<>() ; 
		map.put("escale", Integer.toString(bae.getEscale())) ; 
		map.put("cts", bae.getCts()) ; 
		HttpHeaders  headers = new HttpHeaders()  ;  
		headers.setLocation(builder.path("bae/{escale}/{cts}").buildAndExpand(map).toUri());
		return new ResponseEntity<Void>(headers , HttpStatus.CREATED) ; 
	}
	/*
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return  new ResponseEntity<>(article , HttpStatus.OK) ; 
	}
	*/
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteBae(@PathVariable("id") Integer id) {
		baeService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT) ; 
	}	
	
	
	@GetMapping ("/{escale}/{cts}")
	public ResponseEntity<Bae> getBaeByEscaleCts(@PathVariable("escale") int escale   ,  @PathVariable("id")  String cts  ) {
		Bae bae  = baeService.findByEscaleCts(escale, cts)  ; 
		return new ResponseEntity<Bae>(bae, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> MarkBae(@PathVariable("id") Integer id) {
		baeService.mark(id);
		return new ResponseEntity<Void>(HttpStatus.OK) ; 
	}	
	

}
