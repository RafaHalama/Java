import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Raport extends ObjectPlus{
	
	private static final long serialVersionUID = 1L;
	
	private Date dataStworzenia;
	private String opis;
	private HashMap<String, Gra> graKwalifik = new HashMap<>(); 
	private Archiwista archiwista; //kompozycja calosc
	private Nośnik studio;
	Raport(Date dataStworzenia, String opis, Archiwista archiwista) {
		this.dataStworzenia = dataStworzenia;
		this.opis = opis;
		this.archiwista = archiwista;
		// TODO Auto-generated constructor stub
	}
	
	public static Raport stworzRaport(Date dataStworzenia, String opis, Archiwista archiwista)throws Exception {
		if(archiwista==null) {
			throw new Exception ("Archiwista nie istnieje");
		}
		Raport g = new Raport(dataStworzenia, opis, archiwista);
		
		try {
			archiwista.dodajRaport(g);
		} catch (Exception e) {
			System.out.println("Nie mo�na dodac raportu");
		}
		return g;
	}
	
	
	 public void dodajGre(Gra nowaGra) {
	        if(!graKwalifik.containsKey(nowaGra.tytul)) {
	        	graKwalifik.put(nowaGra.tytul, nowaGra);
	            // Dodaj informację zwrotną
	            nowaGra.dodajRaport(this);
	        }
	    }
	 
	    public Gra znajdzGre(String tytul) throws Exception {
	        if(!graKwalifik.containsKey(tytul)) {
	            throw new Exception("Nie odnaleziono filmu o tytule: " + tytul);
	        }
	        return graKwalifik.get(tytul);
	    }
	 
	
	 
	    
	public String toString()
	{
		String join = new String();
	
		join+="\nData Stworzenia: " + this.dataStworzenia;
		
		join+="\nopis: " + this.opis;
		join+="\n--------------------------\n";

			return join;
		}
	

}
