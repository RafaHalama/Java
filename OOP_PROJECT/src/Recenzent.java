import java.util.ArrayList;
import java.util.Date;

public class Recenzent extends Osoba{
	private static final long serialVersionUID = 1L;
	
	final static double stawkaVat = 1.23; 
	private ArrayList<String> poprzednieMiejscaPracy = new ArrayList<String>(); // powtarzalny 
	private String serwis;
	private double pensja;
	private ArrayList<Recenzja> recenzje = new ArrayList<Recenzja>();	//asocjacja z atrybutem

	
	Recenzent(String imie, String nazwisko, Date dataUrodzenia, String nrTelefonu, double pensja, String serwis) {
		super(imie, nazwisko, dataUrodzenia, nrTelefonu);
		this.pensja = pensja;
		this.serwis = serwis;
		// TODO Auto-generated constructor stub
	}
	
	
	public Recenzent(Osoba poprzedniaOs, String serwis, double pensja) {
		super(poprzedniaOs.imie, poprzedniaOs.nazwisko, poprzedniaOs.dataUrodzenia, poprzedniaOs.nrTelefonu);
		
		this.serwis = serwis;
		this.pensja = pensja;
		} 
	
	public double getPensjaNetto() {
	    return pensja * stawkaVat;
	}
	
	public String getSerwis(){
		return serwis;
	}
	
	public void dodajRecenzję(Recenzja recenzja)
	{
		if(!recenzje.contains(recenzja)) {   
			recenzje.add(recenzja);
			
		}
	}
	
	
	@Override
	public String getFirma() {
		return getSerwis();
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
		
		join+="\nPensja: " + this.getPensjaNetto();
		
		join+="\nSerwis:" + serwis;
		
		join+="\nRecenzje: ";
		for(Recenzja s: recenzje) {
			join += "\n" + s;
			}
		join+="\n--------------------------\n";

			return join;
		}
	
	
}
