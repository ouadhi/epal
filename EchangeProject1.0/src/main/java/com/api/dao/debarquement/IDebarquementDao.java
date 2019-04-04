package com.api.dao.debarquement;

import java.util.List;

import com.api.entity.epal.Debarquement;

public interface IDebarquementDao {
		List<Debarquement> AllDebarequemnts() ; 
		Debarquement byId(int id  ) ; 
		List<Debarquement> byEscale (int escale )  ;   
		boolean add(Debarquement debarquement ) ;
		void delete(int id) ;
		boolean  exist (int  escale , String cts); 
		Debarquement byEscaleId(int escale , String cts ) ; 
}
