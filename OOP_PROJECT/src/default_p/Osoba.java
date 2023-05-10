package default_p;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Osoba {
	String imie;
	String nazwisko;
	String pesel;
	String adresZamieszkania;
	String dataUrodzenia;
	LocalDate pierwszyWynajem;
	List<Pomieszczenie> listaPomieszczen = new ArrayList<>();
	public Osoba(String imie, String nazwisko, String pesel, String adresZamieszkania, String dataUrodzenia,
			LocalDate pierwszyWynajem) {		
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.adresZamieszkania = adresZamieszkania;
		this.dataUrodzenia = dataUrodzenia;
		this.pierwszyWynajem = pierwszyWynajem;
	}
	public void addToList(Pomieszczenie p, int day ,LocalDate d){
		if(p.getRemont() == true){
			p.setOsobaAndDays(this, day, d);
		listaPomieszczen.add(p);
		}
		
	}
	public void setPierwszyWynajem(){
		if(pierwszyWynajem == null){
			this.pierwszyWynajem=  LocalDate.now();
		}
	}
	public LocalDate getPierwszyWynajem() throws NeverRentException{
		if(pierwszyWynajem == null){
			throw new NeverRentException();
		}else{
		return pierwszyWynajem;
	}
		}
	
	public List<Pomieszczenie> getLista(){
		Collections.sort(listaPomieszczen, new Comparator<Pomieszczenie>(){

			@Override
			public int compare(Pomieszczenie o1, Pomieszczenie o2) {
				
				return (int)(o1.getSize() -o2.getSize());
			}
			
		});
		return listaPomieszczen;
	}
	
	
	

}
