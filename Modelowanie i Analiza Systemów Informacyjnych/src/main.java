import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		
		
		
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			
			Archiwista a1,a2=null;
			Recenzent r1,r2;
			Recenzja rec1,rec2;
			Raport rap1,rap2;
			Gra g1,g2;
			Nośnik s1,s2;
			
			Date date = format.parse("1987/04/15");
			a1 = new Archiwista("Jedrzej", "Baran", date,"663 166 218", 5000 );
			a1.dodajMiejsce("Miejsce1");
			a1.dodajMiejsce("Miejsce2","Miejsce3");

			g1 = new Gra("Wiedzmin", 80.0, 20000);
			g2 = new Gra("Wiedzmin 2", 90.0, 40000);
			
			//Powiazanie binarne
			s1 = new Nośnik("Nosnik1", "PlayStation");
			g1.dodajNośnik(s1);
			s1.dodajGre(g1);
			g2.dodajNośnik(s1);
			s1.dodajGre(g2);
			g2.usunNośnik(s1);
			s1.usunGre(g2);
			
			
			
			//Powiazanie z atrybutem
			r1 = new Recenzent("Andrzej", "Baran", date,"662 166 218", 4000, "wp.pl");
			rec1 = new Recenzja(9.3, "Bardzo Dobra", g1, r1);
			rec2 = new Recenzja(9.7, "Bardzo Dobra", g2, r1);
			
			
			//Powiazanie kompozycji
			rap1 = Raport.stworzRaport(date, "Opis raportu", a1);
			try{
			rap2 = Raport.stworzRaport(date, "Opis raportu", a2);
			}catch(Exception e){System.out.println("Czesc nie moze istniec bez calosci");}
			
			
			
			
			
			
			//Powiazanie kwalifikowane
			rap1.dodajGre(g1);
			g1.dodajRaport(rap1);
			System.out.println(rap1.znajdzGre("Wiedzmin"));
			System.out.println();
		
			
			
	
		    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dane"));
		    ObjectPlus.zapiszEkstensje(out);
		 
		    ObjectInputStream in = new ObjectInputStream(new FileInputStream("dane"));
		    ObjectPlus.odczytajEkstensje(in);
		    ObjectPlus.wyswietlEkstensje(Recenzent.class);

		  //  ObjectPlus.wyswietlEkstensje(Recenzja.class);
		    
		    ObjectPlus.wyswietlEkstensje(Raport.class);
		    ObjectPlus.wyswietlEkstensje(Nośnik.class);
		    ObjectPlus.wyswietlEkstensje(Gra.class);
		    
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		 
		
		
	}

}
