import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class Osoba extends ObjectPlus{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String imie;// atrybut prosty
	protected String nazwisko;// atrybut prosty
	protected Date dataUrodzenia;// atrybut zlozony
	private ArrayList<String> imiona;
	protected String nrTelefonu; //opcjonalny
	
	Osoba(String imie, String nazwisko, Date dataUrodzenia,  String nrTelefonu){
		//super();
		
		if(imie == null){throw new NullPointerException("Pole imie nie może być puste.");}
		this.imie = imie;
		
		if(nazwisko == null){throw new NullPointerException("Pole nazwisko nie może być puste.");}
		this.nazwisko = nazwisko;
		
		
		
		this.dataUrodzenia = dataUrodzenia;
		
		
		this.nrTelefonu = nrTelefonu;
		
		
	}
	
	
	
	public String toString(){
		String join = new String();
		join += "Osoba:\nImie: " +this.imie + 
				"\nNazwisko: " + this.nazwisko;
			
		join += "\nData Urodzenia: " + this.dataUrodzenia ;
		 
		
		join += "\nnrTelefonu: ";
		if(nrTelefonu != null)//opcjionalny
			join += nrTelefonu;
		else
			join += "brak";
		
		join+="\n--------------------------\n";

			
		return join;
	}
	
	 
	
}
