package default_p;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Pomieszczenie {
	static int counter = 0 ; 
	int number;
	 double wysokosc;
	 double dlugosc_a;
	 double dlugosc_b;
	 double sizePomieszczenia;
	 boolean czyMozna=true;
	 Osoba o;
	 int days;
	 LocalDate ld;
	 List<Objekt> listaPrzedmiotow = new ArrayList<>();
	 List<Objekt> listaPojazdow = new ArrayList<>();
	public Pomieszczenie(double wysokosc,double dlugosc_a,double dlugosc_b){
		this.wysokosc=wysokosc;
		this.dlugosc_a=dlugosc_a;
		this.dlugosc_b=dlugosc_b;
		sizePomieszczenia=wysokosc*dlugosc_a*dlugosc_b;
		number=++counter;
	}
	public void setOsobaAndDays(Osoba o, int days,LocalDate d){
		if(czyMozna==true){			
		this.o = o ;
		this.days=days;
		this.ld=d;
		}else{
			System.out.println("Pomieszczenie jest w remoncie");
		}
	}
	public Osoba getOsoba(){
		return o;
	}
	public double getSize(){
		return wysokosc*dlugosc_a*dlugosc_b;
	}
	public LocalDate getRemainingDays(){		
		return ld.plusDays(days);		
	}
	public boolean getRemont(){
		return czyMozna;
	}
	public void setRemont(boolean setRmt) {
		if(setRmt==false){
			czyMozna=false; 
		}else{
			czyMozna=true;
		}
		
	}
	
	public String name(){
		String n = (String)(getClass().getName());
		
		String[] na = n.split("\\.");
		//String useless = na[0];
		String usefull =na[1];
		return usefull;
	}
	
	public void wlozPojazd(Objekt p)throws TooManyThingsException{
		double sumap=0;
		for(Objekt prz : listaPojazdow){
			sumap +=prz.getSize();
		}
		if(sumap>this.getSize()){
			throw new TooManyThingsException();
		}else{
			listaPojazdow.add(p);
		}
	}
	public void wlozPrzedmiot(Objekt p)throws TooManyThingsException{
		double suma=0;
		for(Objekt prze : listaPrzedmiotow){
			suma +=prze.getSize();
		}
		if(suma>this.getSize()){
			throw new TooManyThingsException();
		}else{
			listaPrzedmiotow.add(p);
		}		
	}
	
	public void WyjmijPrzedmiot(Objekt pp){
		listaPrzedmiotow.remove(pp);
	}

	public void WyjmijSamochod(Objekt pz){
		listaPojazdow.remove(pz);
	}
	
	public double getRemainingSpace(){
		double space=0;
		for(Objekt o1 : listaPrzedmiotow){
			space += o1.getSize();
		}
		for(Objekt o2 : listaPojazdow){
			space+=o2.getSize();
		}
		
		return this.getSize() - space;
		
	}
	public List<Objekt> getListaPojazdow(){
		Collections.sort(listaPojazdow, new Comparator<Objekt>(){

			@Override
			public int compare(Objekt o1, Objekt o2) {
				
				return (int)(o2.getSize() -o1.getSize());
			}
			
		});
		return listaPojazdow;
	}
	public List<Objekt> getListaPrzedmiotow(){
		Collections.sort(listaPrzedmiotow, new Comparator<Objekt>(){

			@Override
			public int compare(Objekt o1, Objekt o2) {
				
				return (int)(o2.getSize() -o1.getSize());
			}
			
		});
		return listaPrzedmiotow;
	}
	
	
	
	public String toString(){
		return "Pomieszczenie "+name() +" numer: "+ number+ " o wymiarach: "+ dlugosc_a +" x "+dlugosc_b+" x "+wysokosc + ", czyli "+sizePomieszczenia+" m^3" ;
	}

}
