
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

import com.api.entity.douane.Declaration;
import com.api.service.declaration.IDeclarationService;

@Controller
@RequestMapping("declaration")
public class DeclarationController {
	
	@Autowired
	private IDeclarationService   declarationService  ; 
	
	
	@GetMapping("")
	public ResponseEntity<List<Declaration>> startApplication () {
		return new ResponseEntity<List<Declaration>>(declarationService.getAllDeclarations(),HttpStatus.OK)  ; 
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Declaration> getManifestByID(@PathVariable("id") Integer id ) {
       Declaration declaration  = declarationService.getDeclarationByID(id) ; 
		return new ResponseEntity<Declaration>(declaration, HttpStatus.OK);
	}

	@GetMapping("/escale/{escale}")
	public ResponseEntity<List<Declaration>> getDeclarationByEscale(@PathVariable("escale") int escale ) {
		List<Declaration>  liste =  declarationService.getDeclarataionByEscal(escale)  ; 
		return new ResponseEntity<List<Declaration>>(liste, HttpStatus.OK);
	}
	
	@GetMapping("/decl/{numdecl}")
	public ResponseEntity<List<Declaration>> getDeclarationByNumDecl(@PathVariable("numdecl") int numdecl ) {
		List<Declaration>  liste =  declarationService.getdeclarationByNumDecl(numdecl) ; 
		return new ResponseEntity<List<Declaration>>(liste, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Void> addDeclaration (@RequestBody Declaration declaration , UriComponentsBuilder builder){
		boolean  flag   = declarationService.addDeclaration(declaration)  ; 
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT) ; 
		} 
		HttpHeaders  headers = new HttpHeaders()  ;  
		headers.setLocation(builder.path("declaration/decl/{numdecl}").buildAndExpand(declaration.getNum_declaration()).toUri());
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
	    declarationService.deleteDeclaration(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT) ; 
	}	

	
	@PutMapping("/{id}")
	public ResponseEntity<Void>  marquageDeclaration(@PathVariable("id") Integer id ) {
		declarationService.markDeclaration(id);
		return new ResponseEntity<Void>(HttpStatus.OK) ; 
	}
	
	  

}
