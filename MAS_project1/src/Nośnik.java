import java.util.ArrayList;
import java.util.HashSet;

public class Nośnik  extends ObjectPlus{
	 String nazwa;
	private String producent;
	
	private ArrayList<Gra> gry = new ArrayList<Gra>(); //binarna


	Nośnik(String nazwa, String producent) {
		this.nazwa = nazwa;
		this.producent = producent;
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public void dodajGre(Gra newgra) {
		if(!gry.contains(newgra)) {
			gry.add(newgra);
			
			newgra.dodajNośnik(this); //informacja zwrotna
		}
		
	}
	public void usunGre(Gra gra) {
        if(gry.contains(gra)) {
        	gry.remove(gra);
          
        	gra.usunNośnik(this); //informacja zwrotna
        }
    }
	
	public String toString()
	{
		String join = new String();
	
		join+="\nNazwa: " + this.nazwa;
		
		join+="\nProducent: " + this.producent;
		join+="\nGry: ";
		for(Gra s: gry) {
			join += "\n" + s.tytul;
			}
		join+="\n--------------------------\n";

			return join;
		}
	
}
