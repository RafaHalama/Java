package com.example.mas.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity (name = "Silnikgraficzny")
public class Silnikgraficzny{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nazwa;
	private String producent;
	private double aktualna_wersja;
	
	@OneToMany(
			mappedBy = "silnik",
			cascade = CascadeType.ALL)
	private Set<Gra> gry = new HashSet<Gra>();	
	
	Silnikgraficzny(){
		
	}
	
	public Silnikgraficzny(String nazwa,String producent, double aktualna_wersja) {
		this.nazwa = nazwa;
		this.producent = producent;
		this.aktualna_wersja = aktualna_wersja;
		// TODO Auto-generated constructor stub
	}
	

	public void dodajGre(Gra newgra) {
		if(!gry.contains(newgra)) {
			gry.add(newgra);
			
			newgra.dodajSilnik(this); //informacja zwrotna
		}
		
	}


	public long getId() {
		return id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public String getProducent() {
		return producent;
	}

	public double getAktualna_wersja() {
		return aktualna_wersja;
	}

	@Override
	public String toString() {
		return "SilnikGraficzny [nazwa=" + nazwa + ", producent=" + producent + ", aktualna_wersja=" + aktualna_wersja
				+ "]";
	}
	

}
