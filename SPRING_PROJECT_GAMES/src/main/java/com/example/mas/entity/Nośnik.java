package com.example.mas.entity;

import java.util.ArrayList;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import javax.persistence.JoinColumn;
@Entity (name = "Nośnik")
public class Nośnik {
	 @Id  
	  @GeneratedValue(strategy=GenerationType.AUTO)  
	  @Column(name="nośnik_id") 
	private long id;
	
	private String nazwa;
	
	public String producent;
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="gra_nośnik", joinColumns=@JoinColumn(name="nośnik_id"), inverseJoinColumns=@JoinColumn(name="gra_id"))  
	private Set<Gra> gry = new HashSet<Gra>(); 

	
	
	protected Nośnik(){}
	
	public Nośnik(String nazwa, String producent) {
		super();
		this.nazwa = nazwa;
		this.producent = producent;
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

	public void setId(long id) {
		this.id = id;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public void setProducent(String producent) {
		this.producent = producent;
	}

	@Override
	public String toString() {
		return "Nośnik [id=" + id + ", nazwa=" + nazwa + ", producent=" + producent + "]";
	}

	

	public void dodajGre(Gra newgra) {
		if (!gry.contains(newgra)) {
			gry.add(newgra);

			newgra.dodajNośnik(this); 
		}

	}

	public void usunGrę(Gra gra) {
		if(gry.contains(gra)) {
			gry.remove(gra);
 
            // Remove the reverse link
			gra.usunNośnik(this);
        }
    }
	




	

}
