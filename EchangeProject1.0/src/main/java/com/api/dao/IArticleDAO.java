package com.api.dao;

import java.util.List;

import com.api.entity.Article;
public interface IArticleDAO {
	
	 List<Article> getAllArticles () ; 
	 Article getArticle(int articleId) ; 
	 void addArticle(Article article ) ; 
	 void updateArticle (Article article) ; 
	 void deleteArticle (int articleId) ;
	 boolean articleExists (String title , String category) ; 
	
}
