package com.api.entity.epal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Debarquement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id  ;  
	@Column
	private int escale ; 
	private String bl; ;  
	@Column
	private String cts ;  
	@Column
	private String Type_cts ; 
	@Column
	private String position ; 
	@Column
	private Date date_debarequement ;  
	@Column
	private Date date_arrivee ;  
	@Column
	private Date date_accostage ;
	@Column
	private Date date_ajoute ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEscale() {
		return escale;
	}
	public void setEscale(int escale) {
		this.escale = escale;
	}
	public String getBl() {
		return bl;
	}
	public void setBl(String bl) {
		this.bl = bl;
	}
	public String getCts() {
		return cts;
	}
	public void setCts(String cts) {
		this.cts = cts;
	}
	public String getType_cts() {
		return Type_cts;
	}
	public void setType_cts(String type_cts) {
		Type_cts = type_cts;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getDate_debarequement() {
		return date_debarequement;
	}
	public void setDate_debarequement(Date date_debarequement) {
		this.date_debarequement = date_debarequement;
	}
	public Date getDate_arrivee() {
		return date_arrivee;
	}
	public void setDate_arrivee(Date date_arrivee) {
		this.date_arrivee = date_arrivee;
	}
	public Date getDate_accostage() {
		return date_accostage;
	}
	public void setDate_accostage(Date date_accostage) {
		this.date_accostage = date_accostage;
	}
	public Date getDate_ajoute() {
		return date_ajoute;
	}
	public void setDate_ajoute(Date date_ajoute) {
		this.date_ajoute = date_ajoute;
	} 
	
	
	
}
