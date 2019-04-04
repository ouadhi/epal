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
public class SortiePhysique {
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
	private Date date_sortie ; 
	@Column
	private String camion ; 
	@Column
	private String desc_mession  ;
	@Column
	private Date date_ajoute  ; 
	
	public SortiePhysique(int id, int escale, String cts, String type_cts, Date date_sortie, String camion,
			String desc_mession, Date date_ajoute) {
		super();
		this.id = id;
		this.escale = escale;
		this.cts = cts;
		Type_cts = type_cts;
		this.date_sortie = date_sortie;
		this.camion = camion;
		this.desc_mession = desc_mession;
		this.date_ajoute = date_ajoute;
	}
	
	public SortiePhysique(int escale, String cts, String type_cts, Date date_sortie, String camion,
			String desc_mession) {
		super();
		this.escale = escale;
		this.cts = cts;
		Type_cts = type_cts;
		this.date_sortie = date_sortie;
		this.camion = camion;
		this.desc_mession = desc_mession;
	}
	
	
	public SortiePhysique() {
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
		this.cts = cts;
	}
	public String getType_cts() {
		return Type_cts;
	}
	public void setType_cts(String type_cts) {
		Type_cts = type_cts;
	}
	public Date getDate_sortie() {
		return date_sortie;
	}
	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}
	public String getCamion() {
		return camion;
	}
	public void setCamion(String camion) {
		this.camion = camion;
	}
	public String getDesc_mession() {
		return desc_mession;
	}
	public void setDesc_mession(String desc_mession) {
		this.desc_mession = desc_mession;
	}
	public Date getDate_ajoute() {
		return date_ajoute;
	}
	public void setDate_ajoute(Date date_ajoute) {
		this.date_ajoute = date_ajoute;
	} 
	
	
	
	

}
