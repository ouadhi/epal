package com.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.Article;

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {
	
	@PersistenceContext
	private EntityManager entityManager  ; 

	@Override
	public List<Article> getAllArticles() {
        String hql =  " FROM Article "  ; 
		List<Article> resultList = (List<Article>) entityManager.createQuery(hql).getResultList();
		return  resultList;
	}

	@Override
	public Article getArticle(int articleId) {
		Article  obj  =  entityManager.find(Article.class,articleId) ; 
		return obj;
	}

	@Override
	public void addArticle(Article article) {
		entityManager.persist(article);	
	}

	@Override
	public void updateArticle(Article article) {
		
	Article  obj  = getArticle(article.getArticleId()) ;
	
	obj.setName(article.getName());
	obj.setCategory(article.getCategory());
	
	entityManager.flush();
		
	}

	@Override
	public void deleteArticle(int articleId) {
		entityManager.remove(getArticle(articleId));
		
	}

	@Override
	public boolean articleExists(String title, String category) {
		
		String  hql  = "FROM Article WHERE title = ?1 and category = ?2" ; 
		int  cout  =  entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category).getResultList().size();
		
		return cout > 0 ? true : false  ;
	}

}
