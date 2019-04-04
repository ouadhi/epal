package com.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="articles")
public class Article implements  Serializable{
	
	private static final long serialVersionUID  = 1L  ; 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="article_id")
	private int articleId  ; 
	@Column(name="title")
	private String name  ;  
	@Column(name="category")
	private String category ;
	
	public Article(int articleId, String name, String category) {
		this.articleId = articleId;
		this.name = name;
		this.category = category;
	}  
	
	public Article() {
		
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
