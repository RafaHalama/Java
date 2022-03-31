import java.util.ArrayList;
import java.util.HashMap;

public class Gra  extends ObjectPlus{
	private static final long serialVersionUID = 1L;
		
	 String tytul;
	private Double cena;
	private int ilosc_sprzedanych_kopii;
	private ArrayList<Recenzja> recenzje = new ArrayList<Recenzja>();	 //asocjacja z atrybutem
	private Raport raport;
	private ArrayList<Raport> raporty = new ArrayList<Raport>(); //kwalifikowana
	private ArrayList<Nośnik> nośniki = new ArrayList<Nośnik>(); //binarna

	Gra(String tytul, Double cena, int ilosc_sprzedanych_kopii) {
		this.tytul = tytul;
		this.cena = cena;
		this.ilosc_sprzedanych_kopii = ilosc_sprzedanych_kopii;
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public void dodajNośnik(Nośnik nośnik) {
		if(!nośniki.contains(nośnik)) {
			nośniki.add(nośnik);
			
			nośnik.dodajGre(this); //informacja zwrotna
		}
		
	}
	
	public void usunNośnik(Nośnik nośnik) {
        if(nośniki.contains(nośnik)) {
        	nośniki.remove(nośnik);
          
        	nośnik.usunGre(this); //informacja zwrotna
        }
    }
	
	public void dodajRecenzję(Recenzja recenzja)
	{
		if(!recenzje.contains(recenzja)) {   
			recenzje.add(recenzja);
			
		}
	}
	
	
	public void dodajRaport(Raport raport) {
		if(this.raport==null) {
		this.raport = raport;
		raport.dodajGre(this);
		}
	}

	
	public String toString()
	{
		String join = new String();
	
		join+="\nTytuł: " + this.tytul;
		
		join+="\ncena: " + this.cena;
		
		join+="\nIlość Sprzedanych Kopii: " + this.ilosc_sprzedanych_kopii;
		
		join+="\nNośniki: ";
		for(Nośnik s: nośniki) {
			join += "\n" + s.nazwa;
			}
		join+="\n--------------------------\n";

			return join;
		}
	
	
}
