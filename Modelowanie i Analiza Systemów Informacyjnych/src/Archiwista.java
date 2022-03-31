import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Archiwista extends Osoba {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static double stawkaVat = 1.23; 

	private ArrayList<String> poprzednieMiejscaPracy = new ArrayList<String>(); // powtarzalny 
	private static String firma = "Archiwum gier komputerowych ARK"; //klasowy 
	private double pensjaNetto;
	private ArrayList<Raport> raporty = new ArrayList<Raport>(); //kompozycja czesc
	Archiwista(String imie, String nazwisko, Date dataUrodzenia, String nrTelefonu, int pensja) {
		super(imie, nazwisko, dataUrodzenia, nrTelefonu);
		this.pensjaNetto = pensja;
		// TODO Auto-generated constructor stub
	}
	
	public void dodajMiejsce(String nazwa) throws Exception
	{
		if(nazwa == null)
	{
		throw new Exception("Pole nie moze byc puste");
	}
		poprzednieMiejscaPracy.add(nazwa);
	}
	
	public double getPensja() {
	    return pensjaNetto * stawkaVat;
	}
	
	
	public void dodajMiejsce(String... args) throws Exception{
	    for (String arg : args) {
	    	if(arg == null)
	    	{
	    		throw new Exception("Pole nie moze byc puste");
	    	}
	    	poprzednieMiejscaPracy.add(arg);
	    }
	}
	
	
	
	public void dodajRaport(Raport g) throws Exception {
		if(raporty.contains(g)) {
				throw new Exception("Ten raport jest juz powiazany");
			
			
		}
		raporty.add(g);
	}
	
	
	
	
	public String toString()
	{
		String join = super.toString() + "\n";
		join+="Poprzednie miejsca pracy: ";
		if(poprzednieMiejscaPracy.size() > 0)
		{
			for(String x : poprzednieMiejscaPracy)
			{
				join += x + ", ";
			}
		}
		else
		{
			join += "brak";
		}
		
		join+="\nPensja: " + this.getPensja();
		
		join+="\nNazwa Firmy:" + firma;
		join+="\n--------------------------\n";

			return join;
		}
		
	 
	
}
