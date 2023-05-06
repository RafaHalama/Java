package default_p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class NaSamochody extends Pomieszczenie implements NaWynajem  {
	Osoba o ;
	private int days;
	boolean czyMozna=true;
	Date d;
	List<Objekt> listaPojazdow = new ArrayList<>();
public NaSamochody(double wysokosc,double dlugosc_a,double dlugosc_b){
	super(wysokosc, dlugosc_a, dlugosc_b);
}


/*public void wloz(Objekt p)throws TooManyThingsException{
	double suma=0;
	for(Objekt prz : listaPojazdow){
		suma +=prz.getSize();
	}
	if(suma>wysokosc*dlugosc_a*dlugosc_b){
		throw new TooManyThingsException();
	}else{
		listaPojazdow.add(p);
	}
}*/
	
	/*public void Wyjmij(Objekt pz){
		listaPojazdow.remove(pz);
	}*/
public List<Objekt> getLista(){
	Collections.sort(listaPojazdow, new Comparator<Objekt>(){

		@Override
		public int compare(Objekt o1, Objekt o2) {
			
			return (int)(o2.getSize() -o1.getSize());
		}
		
	});
	return listaPojazdow;
}

	




//public String toString(){
	//return "Pomieszczenie na samochody numer: "+ number+ " o wymiarach: "+ dlugosc_a +" x "+dlugosc_b+" x "+wysokosc + ", czyli "+objetosc()+" m^3" ;
//}
}
