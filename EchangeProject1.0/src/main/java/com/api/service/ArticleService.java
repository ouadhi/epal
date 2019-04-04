package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.IArticleDAO;
import com.api.entity.Article;

@Service
public class ArticleService implements IArticleService {

	@Autowired
	IArticleDAO articleDAO;

	@Override
	public List<Article> getAllArticles() {

		return articleDAO.getAllArticles();
	}

	@Override
	public Article getArticleById(int articleId) {

		return articleDAO.getArticle(articleId);
	}

	@Override
	public boolean addArticle(Article article) {
		if (articleDAO.articleExists(article.getName(), article.getCategory())) {
			return false;
		} else {
			articleDAO.addArticle(article);
			return true;
		}

	}

	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);

	}

	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);

	}

}
