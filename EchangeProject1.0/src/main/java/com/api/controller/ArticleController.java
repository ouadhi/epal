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

import com.api.entity.Article;
import com.api.service.IArticleService;

@Controller
@RequestMapping("user")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService  ; 
	
	@GetMapping("/")
	public ResponseEntity<String> startApplication () {
		return new ResponseEntity<String>("Hello",HttpStatus.OK)  ; 
	}
	
	@GetMapping("articles")
	public ResponseEntity<List<Article>> getAllArtilces() {
		List<Article> list = articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}
	
	@GetMapping("article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
		Article article = articleService.getArticleById(id);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	@PostMapping("article")
	public ResponseEntity<Void> addArticle (@RequestBody Article article , UriComponentsBuilder builder){
		boolean  flag   =  articleService.addArticle(article) ; 
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT) ; 
		} 
		HttpHeaders  headers = new HttpHeaders()  ;  
		headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
		return new ResponseEntity<Void>(headers , HttpStatus.CREATED) ; 
	}
	
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return  new ResponseEntity<>(article , HttpStatus.OK) ; 
	}
	
	
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> DeleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT) ; 
	}
	
	
	@GetMapping("hello")
	public String sayHello ()  {
		String msg  = "hello" ; 
		return msg ;  
	}

}
