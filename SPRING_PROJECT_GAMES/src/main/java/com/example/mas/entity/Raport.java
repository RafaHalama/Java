package com.example.mas.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity (name = "Raport")
public class Raport {
	
	@Id
	@GeneratedValue
	private long id;
	private Date dataStworzenia;
	private String opis;
	@ManyToOne
	private Gra gra;
	@ManyToOne
	private Archiwista archiwista;
	
	Raport(){
		
	}
	public Raport(Date dataStworzenia, String opis,Gra gra, Archiwista archiwista) {
		this.dataStworzenia = dataStworzenia;
		this.opis = opis;
		this.archiwista = archiwista;
		this.gra = gra;
		gra.dodajRaport(this);
		archiwista.dodajRaport(this);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Raport [dataStworzenia=" + dataStworzenia + ", opis=" + opis + ", gra=" + gra + "]";
	}
	
	
	

}
