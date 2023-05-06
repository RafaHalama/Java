package com.example.mas.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity (name = "Recenzent")
public class Recenzent extends Osoba{
	
	
	final static double stawkaVat = 1.23; 
	private ArrayList<String> poprzednieMiejscaPracy = new ArrayList<String>(); // powtarzalny 
	private String serwis;
	private double pensja;
	@OneToMany(mappedBy = "recenzent")
	private Set<Recenzja> recenzje = new HashSet<Recenzja>(); 	//asocjacja z atrybutem

	Recenzent(){
		
	}
	Recenzent(String imie, String nazwisko, Date dataUrodzenia, String nrTelefonu, double pensja, String serwis)throws Exception {
		super(imie, nazwisko, dataUrodzenia, nrTelefonu);
		this.pensja = pensja;
		this.serwis = serwis;
		// TODO Auto-generated constructor stub
	}
	

	
	public double getPensjaBrutto() {
	    return pensja * stawkaVat;
	}
	
	public String getSerwis(){
		return serwis;
	}
	
	public void dodajRecenzję(Recenzja recenzja)
	{
		if(!recenzje.contains(recenzja)) {   
			recenzje.add(recenzja);
			
		}
	}



	@Override
	public String toString() {
		return "Recenzent [poprzednieMiejscaPracy=" + poprzednieMiejscaPracy + ", serwis=" + serwis + ", pensja="
				+ pensja + "]";
	}
	

	
	
	
	
}
