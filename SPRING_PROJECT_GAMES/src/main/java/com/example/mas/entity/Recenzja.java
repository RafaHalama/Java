package com.example.mas.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity (name = "Recenzja")
public class Recenzja  {
	@Id
	@GeneratedValue
	private long id;
	private Double ocena;
	private String opis;
	private Date dataStworzenia;
	@ManyToOne
	private Gra gra;
	@ManyToOne
	private Recenzent recenzent;
	
	
	public Recenzja(){
		
	}
	public Recenzja(Double ocena, String opis, Gra gra, Recenzent recenzent, Date dataStworzenia) {
		this.ocena = ocena;
		this.opis = opis;
		this.gra = gra;
		this.recenzent = recenzent;
		this.dataStworzenia = dataStworzenia;
		// TODO Auto-generated constructor stub
		gra.dodajRecenzję(this);
		recenzent.dodajRecenzję(this);
	}

	@Override
	public String toString() {
		return "Recenzja [ocena=" + ocena + ", opis=" + opis + ", dataStworzenia=" + dataStworzenia + "]";
	}
	
	
	

}
