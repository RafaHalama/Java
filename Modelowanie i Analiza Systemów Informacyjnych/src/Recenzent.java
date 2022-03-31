import java.util.ArrayList;
import java.util.Date;

public class Recenzent extends Osoba{
	private static final long serialVersionUID = 1L;
	
	final static double stawkaVat = 1.23; 
	private ArrayList<String> poprzednieMiejscaPracy = new ArrayList<String>(); // powtarzalny 
	private String serwis;
	private double pensjaNetto;
	private ArrayList<Recenzja> recenzje = new ArrayList<Recenzja>();	//asocjacja z atrybutem

	
	Recenzent(String imie, String nazwisko, Date dataUrodzenia, String nrTelefonu, int pensja, String serwis) {
		super(imie, nazwisko, dataUrodzenia, nrTelefonu);
		this.pensjaNetto = pensja;
		this.serwis = serwis;
		// TODO Auto-generated constructor stub
	}
	public double getPensja() {
	    return pensjaNetto * stawkaVat;
	}
	
	
	
	public void dodajRecenzję(Recenzja recenzja)
	{
		if(!recenzje.contains(recenzja)) {   
			recenzje.add(recenzja);
			
		}
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
		
		join+="\nSerwis:" + serwis;
		
		join+="\nRecenzje: ";
		for(Recenzja s: recenzje) {
			join += "\n" + s;
			}
		join+="\n--------------------------\n";

			return join;
		}
	
}
