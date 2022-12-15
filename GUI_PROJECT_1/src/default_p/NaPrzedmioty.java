package default_p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;



public class NaPrzedmioty extends Pomieszczenie implements NaWynajem{
	Osoba o ;
	private int days;
	boolean czyMozna=true;
	Date d;
	List<Objekt> listaPrzedmiotow = new ArrayList<>();
	
	public NaPrzedmioty(double wysokosc,double dlugosc_a,double dlugosc_b){
		super(wysokosc, dlugosc_a, dlugosc_b);
	}
	
	
	
	
	/*public void wloz(Objekt p)throws TooManyThingsException{
		double suma=0;
		for(Objekt prz : listaPrzedmiotow){
			suma +=prz.getSize();
		}
		if(suma>wysokosc*dlugosc_a*dlugosc_b){
			throw new TooManyThingsException();
		}else{
			listaPrzedmiotow.add(p);
		}
		
		
	}
	public void Wyjmij(Objekt pp){
		listaPrzedmiotow.remove(pp);
	}	*/
	public List<Objekt> getLista(){
		Collections.sort(listaPrzedmiotow, new Comparator<Objekt>(){

			@Override
			public int compare(Objekt o1, Objekt o2) {
				
				return (int)(o2.getSize() -o1.getSize());
			}
			
		});
		return listaPrzedmiotow;
	}
	
	
	/*public String toString(){
		return "Pomieszczenie na przedmioty numer: "+number+ " o wymiarach "+ dlugosc_a +" x "+dlugosc_b+" x "+wysokosc + ", czyli "+objetosc()+" m^3" ;
	}*/

}
