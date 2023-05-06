package com.example.mas.service;
import java.util.ArrayList;

import com.example.mas.entity.Raport;

public interface IArchiwista {

	    public abstract double getDochody();
	    public abstract double getPensjaArchiwisty();
	    public abstract String getFirmy();
	    public abstract String getPoprzednieMiejscePracy();
	    public abstract void dodajRaport(Raport raport);
}
