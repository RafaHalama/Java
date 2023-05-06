package com.example.mas.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity (name = "Studio")
public class Studio {
	
	
	@Id
	@GeneratedValue
	private long id;
	private String nazwa;
	private String lokalizacja;
	private int ilosc_pracownikow;
	
	@OneToMany(
			mappedBy = "studio",
			cascade = CascadeType.ALL)
	private Set<Gra> gry = new HashSet<Gra>(); // KOMPOZYCJA CALOSC
	
	public Studio(){
		
	}
	
	public Studio(String nazwa,String lokalizacja, int ilosc_pracownikow) {
		this.nazwa = nazwa;
		this.lokalizacja = lokalizacja;
		this.ilosc_pracownikow = ilosc_pracownikow;
	}
	

	public void dodajGre(Gra g) throws Exception {
		if(gry.contains(g)) {
				throw new Exception("Ta gra jest juz powiazana");
			
			
		}
		gry.add(g);
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getLokalizacja() {
		return lokalizacja;
	}

	public void setLokalizacja(String lokalizacja) {
		this.lokalizacja = lokalizacja;
	}

	public int getIlosc_pracownikow() {
		return ilosc_pracownikow;
	}

	public void setIlosc_pracownikow(int ilosc_pracownikow) {
		this.ilosc_pracownikow = ilosc_pracownikow;
	}

	@Override
	public String toString() {
		return "Studio [nazwa=" + nazwa + ", lokalizacja=" + lokalizacja + ", ilosc_pracownikow=" + ilosc_pracownikow
				+ "]";
	}
	
	
	 
	    
	
	

}
