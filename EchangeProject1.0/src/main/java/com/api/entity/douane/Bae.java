package com.api.entity.douane;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Bae {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id  ;  
	@Column
	private int escale ; 
	@Column
	private int annee_manifest  ; 
	@Column 
	private int num_manifest ; 
	@Column
	private int ligne ; 
	@Column
	private int  groupe ; 
	@Column
	private int  code_bureau ; 
	@Column
	private String bl; ;  
	@Column
	private String cts ;  
	@Column
	private String Type_cts ; 
	@Column
	private int num_declaration  ; 
	@Column
	private Date date_bae  ;  
	@Column
	@JsonIgnore
	private boolean  flag = false ; 
	@Column
	@JsonIgnore
	private Date date_marquage  ;
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
	public int getAnnee_manifest() {
		return annee_manifest;
	}
	public void setAnnee_manifest(int annee_manifest) {
		this.annee_manifest = annee_manifest;
	}
	public int getNum_manifest() {
		return num_manifest;
	}
	public void setNum_manifest(int num_manifest) {
		this.num_manifest = num_manifest;
	}
	public int getLigne() {
		return ligne;
	}
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	public int getGroupe() {
		return groupe;
	}
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	public int getCode_bureau() {
		return code_bureau;
	}
	public void setCode_bureau(int code_bureau) {
		this.code_bureau = code_bureau;
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
	public int getNum_declaration() {
		return num_declaration;
	}
	public void setNum_declaration(int num_declaration) {
		this.num_declaration = num_declaration;
	}
	public Date getDate_bae() {
		return date_bae;
	}
	public void setDate_bae(Date date_bae) {
		this.date_bae = date_bae;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Date getDate_marquage() {
		return date_marquage;
	}
	public void setDate_marquage(Date date_marquage) {
		this.date_marquage = date_marquage;
	} 

	
	

}
