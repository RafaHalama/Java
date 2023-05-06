package com.example.mas.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.mas.service.IArchiwista;
@Entity (name = "ArchiwistaRecenzent")
public class ArchiwistaRecenzent extends Recenzent implements IArchiwista {

	private static String firma = "Archiwum gier komputerowych ARK"; 
	private String poprzednieMiejscePracy; 
	private double pensja;
	final static double stawkaVat = 1.23; 
    
    public ArchiwistaRecenzent(String imie, String nazwisko, Date dataUrodzenia, String nrtelefonu, double pensja, String serwis, int pensja2, String poprzednie) throws Exception {
        super(imie, nazwisko, dataUrodzenia,nrtelefonu, pensja, serwis);
 
        this.pensja = pensja2;
        this.poprzednieMiejscePracy = poprzednie;
    }
 
    
    
    public double getPensjaArchiwisty() {
        return pensja * stawkaVat;
    }
 
    
    public double getDochody() {
        return super.getPensjaBrutto() + getPensjaArchiwisty();
    }
 
    public String getFirmy() {
        return firma + " " + super.getSerwis();
    }

	@Override
	public String getPoprzednieMiejscePracy() {
		return poprzednieMiejscePracy;
	}



	@Override
	public void dodajRaport(Raport raport) {
		
		
	}
}