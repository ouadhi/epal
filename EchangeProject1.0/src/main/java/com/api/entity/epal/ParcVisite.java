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
public class ParcVisite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id  ;  
	@Column
	private int escale ; 
	@Column
	private String cts ;  
	@Column
	private String Type_cts ; 
	@Column
	private String type_visite ; 
	@Column
	private Date date_programation ; 
	@Column 
	private Date date_ajoute ;
	
	
	
	public ParcVisite(int id, int escale, String cts, String type_cts, String type_visite, Date date_programation) {
		super();
		this.id = id;
		this.escale = escale;
		this.cts = cts;
		Type_cts = type_cts;
		this.type_visite = type_visite;
		this.date_programation = date_programation;
	}
	
	
	public ParcVisite() {
		super();
	}


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
	public String getCts() {
		return cts;
	}
	public void setCts(String cts) {
		this.cts	 = cts;
	}
	public String getType_cts() {
		return Type_cts;
	}
	public void setType_cts(String type_cts) {
		Type_cts = type_cts;
	}
	public String getType_visite() {
		return type_visite;
	}
	public void setType_visite(String type_visite) {
		this.type_visite = type_visite;
	}
	public Date getDate_programation() {
		return date_programation;
	}
	public void setDate_programation(Date date_programation) {
		this.date_programation = date_programation;
	}
	public Date getDate_ajoute() {
		return date_ajoute;
	}
	public void setDate_ajoute(Date date_ajoute) {
		this.date_ajoute = date_ajoute;
	} 
	
	
	
	
	
}
