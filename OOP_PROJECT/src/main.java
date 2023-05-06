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
			Date date = format.parse("1987/04/15");

			/*Archiwista a1,a2=null;
			Recenzent r1,r2;
			Recenzja rec1,rec2;
			Raport rap1,rap2;
			Gra g1,g2;
			Nośnik s1,s2;
			
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
		*/
			
			
			
			

			
			
			Osoba os1 =  new Recenzent("Andrzej", "Baran", date,"662 166 218", 4000, "wp.pl");
			Osoba os2 =  new Archiwista("Jedrzej", "Baran", date,"663 166 218", 5000 );
			System.out.println(os1.getFirma());
			System.out.println(os2.getFirma());
			/////////////////////////////////////
			System.out.println();
			ArchiwistaRecenzent ar = new ArchiwistaRecenzent("Arek", "Baran", date , "232323", 3000, "wp.pl", 5000, null);
			System.out.println(ar.getDochody());
			System.out.println(ar.getFirmy());
			
			/////////////////////////////////////
			System.out.println();
			Osoba os3 = new Recenzent("Jakub", "Baran", date,"222222", 3000, "onet.pl");
			System.out.println(os3);
			 os3 = new Archiwista(os3, 5000);
			 System.out.println(os3);
			 os3 = new Recenzent(os3, "o2.pl", 3500);
			 System.out.println(os3);
			 //////////////////////////////////////
			 Gra gra1 = new Gra("Wiedzmin", 80.0, 10000, "single", "3D");
			 Gra gra2 = new Gra("Battlefield", 100.0, 20000,"single_multi", "2D");
			 
			 
			 gra1.setKampania(50);
			 System.out.println("Dlugosc kampanii:" + gra1.hasKampania());
			 gra1.getGameType();
			 
			 gra2.setKampania(120);
			 gra2.setSerwery(12);
			 gra2.setIloscGraczy(100000);
			 System.out.println("Dlugosc kampanii:" + gra2.hasKampania());
			 System.out.println("Ilosc Serwerow:" + gra2.hasSerwery());
			 System.out.println("Najwieksza Liczba graczy:" + gra2.hasIloscGraczy());
			 gra2.getGameType();
			 
			 //////////////////////////////////////////////////////////////////
			 gra1.setKamera("ortodoksalna");
			 gra1.set2D("sdsd");
			 //////////////////////////////////////////////////////////////////
			 
			 
		    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dane"));
		    ObjectPlus.zapiszEkstensje(out);
		 
		    ObjectInputStream in = new ObjectInputStream(new FileInputStream("dane"));
		   // ObjectPlus.odczytajEkstensje(in);
		    
		    
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		 
		
		
	}

}
