package com.api.entity.douane;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Manifest implements Serializable {

	private static final long serialVersionUID = 1L;
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
	private String position ; 
	@Column
	private Date date_debarequement ;  
	@Column
	private Date date_arrivee ;  
	@Column
	private Date date_accostage ;
	@Column
	@JsonIgnore
	private boolean  flag ; 
	@Column
	@JsonIgnore
	private Date date_marquage  ; 
	
	
	
	public Manifest(int id, int escale, int annee_manifest, int num_manifest, int ligne, int groupe, int code_bureau,
			String bl, String cts, String type_cts, String position, Date date_debarequement, Date date_arrivee,
			Date date_accostage, boolean flag, Date date_marquage) {
		super();
		this.id = id;
		this.escale = escale;
		this.annee_manifest = annee_manifest;
		this.num_manifest = num_manifest;
		this.ligne = ligne;
		this.groupe = groupe;
		this.code_bureau = code_bureau;
		this.bl = bl;
		this.cts = cts;
		Type_cts = type_cts;
		this.position = position;
		this.date_debarequement = date_debarequement;
		this.date_arrivee = date_arrivee;
		this.date_accostage = date_accostage;
		this.flag = flag;
		this.date_marquage = date_marquage;
	}
	
	
	
	public Manifest(int escale, int annee_manifest, int num_manifest, int ligne, int groupe, int code_bureau, String bl,
			String cts, String type_cts, String position, Date date_debarequement, Date date_arrivee,
			Date date_accostage) {
		super();
		this.escale = escale;
		this.annee_manifest = annee_manifest;
		this.num_manifest = num_manifest;
		this.ligne = ligne;
		this.groupe = groupe;
		this.code_bureau = code_bureau;
		this.bl = bl;
		this.cts = cts;
		Type_cts = type_cts;
		this.position = position;
		this.date_debarequement = date_debarequement;
		this.date_arrivee = date_arrivee;
		this.date_accostage = date_accostage;
	}


	public Manifest() {
		// TODO Auto-generated constructor stub
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


	public void setGroup(int groupe) {
		this.groupe = groupe;
	}


	public int getCode_bureau() {
		return code_bureau;
	}


	public void setCode_bureau(int code_bureau) {
		this.code_bureau = code_bureau;
	}

	
	
	
}
