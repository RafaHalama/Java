package com.example.mas.entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class Osoba{
	
	@Id
	@GeneratedValue
	private long id;
	protected String imie;// atrybut prosty
	protected String nazwisko;// atrybut prosty
	protected Date dataUrodzenia;// atrybut zlozony

	protected String nrTelefonu; 
	
	Osoba(){
		
	}
	
	Osoba(String imie, String nazwisko, Date dataUrodzenia,  String nrTelefonu)
			throws Exception{
		
		if(imie == null){throw new NullPointerException("Pole imie nie może być puste.");}
		this.imie = imie;
		
		if(nazwisko == null){throw new NullPointerException("Pole nazwisko nie może być puste.");}
		this.nazwisko = nazwisko;
		
		this.nrTelefonu = nrTelefonu;
		
		this.dataUrodzenia = dataUrodzenia;	
		
	}


	@Override
	public String toString() {
		return "Osoba [imie=" + imie + ", nazwisko=" + nazwisko + ", dataUrodzenia=" + dataUrodzenia + ", nrTelefonu=" + nrTelefonu + "]";
	}


	public String getImie() {
		return imie;
	}


	public String getNazwisko() {
		return nazwisko;
	}


	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}


	

	public String getNrTelefonu() {
		return nrTelefonu;
	}


	
	
	
	 
	
}
