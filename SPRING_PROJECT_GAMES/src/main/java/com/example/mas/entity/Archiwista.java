package com.example.mas.entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity (name = "Archiwista")
public class Archiwista extends Osoba {

	final static double stawkaVat = 1.23; 

	private String poprzednieMiejscePracy; // powtarzalny 
	private static String firma = "Archiwum gier komputerowych ARK"; //klasowy 
	private double pensja;
	
	@OneToMany(mappedBy = "archiwista")
	private Set<Raport> raporty = new HashSet<Raport>();  //asocjacja z atrybutem
	
	Archiwista(){
	}
	
	public Archiwista(String imie, String nazwisko, Date dataUrodzenia, String nrTelefonu, double pensja) throws Exception{
		super(imie, nazwisko, dataUrodzenia, nrTelefonu);
		this.pensja = pensja;
	}
	
	

	
	
	
	
	public double getPensjaBrutto() {
	    return pensja * stawkaVat;
	}
	
	public String getArchiwum(){
		return firma;
	}
	
	



	
	
	
	
	@Override
	public String toString() {
		return "Archiwista [poprzednieMiejscePracy=" + poprzednieMiejscePracy + ", pensja=" + pensja + "]";
	}

	public void dodajRaport(Raport raport)
	{
		if(!raporty.contains(raport)) {   
			raporty.add(raport);
			
		}
	}

	public String getPoprzednieMiejscePracy() {
		return poprzednieMiejscePracy;
	}

	public void setPoprzednieMiejscePracy(String poprzednieMiejscePracy) {
		this.poprzednieMiejscePracy = poprzednieMiejscePracy;
	}
	




	

	
	


	 
	
}
