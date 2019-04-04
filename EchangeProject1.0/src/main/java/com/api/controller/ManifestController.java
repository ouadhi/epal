package com.api.controller;

import java.util.List;

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

import com.api.entity.douane.Manifest;
import com.api.service.manifest.IServiceManifest;

@Controller
@RequestMapping("manifest")
public class ManifestController {
	
	@Autowired
	private IServiceManifest service  ; 
	
	@GetMapping("")
	public ResponseEntity<List<Manifest>> getAllmanifest () {
		return new ResponseEntity<List<Manifest>>(service.getAllManifests(),HttpStatus.OK)  ; 
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Manifest> getManifestByID(@PathVariable("id") Integer id ) {
        Manifest  manifest  = service.getManifestByID(id) ;  		
		return new ResponseEntity<Manifest>(manifest, HttpStatus.OK);
	}
	
	@GetMapping("/escale/{escale}")
	public ResponseEntity<List<Manifest>> getManifesteByEscale(@PathVariable("escale") int escale ) {
		List<Manifest>  liste =  service.getManifestByEscal(escale);  
		return new ResponseEntity<List<Manifest>>(liste, HttpStatus.OK);
	}
	
	
	@PostMapping("")
	public ResponseEntity<Void> addArticle (@RequestBody Manifest manifest , UriComponentsBuilder builder){
		boolean  flag   =  service.addManifest(manifest) ; 
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT) ; 
		} 
		HttpHeaders  headers = new HttpHeaders()  ;  
		headers.setLocation(builder.path("/id/{id}").buildAndExpand(manifest.getId()).toUri());
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
	public ResponseEntity<Void> DeleteArticle(@PathVariable("id") Integer id) {
		service.deleteManifest(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT) ; 
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> marquageManifest(@PathVariable("id") Integer id){
		service.markManifest(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED)  ; 
	}

}
