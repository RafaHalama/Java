import java.util.Date;

public class Recenzja  extends ObjectPlus{
	private static final long serialVersionUID = 1L;
	
	private Double ocena;
	private String opis;
	private Gra gra;
	private Recenzent recenzent;
	
	Recenzja(Double ocena, String opis, Gra gra, Recenzent recenzent) {
		this.ocena = ocena;
		this.opis = opis;
		this.gra = gra;
		this.recenzent = recenzent;
		// TODO Auto-generated constructor stub
		gra.dodajRecenzję(this);
		recenzent.dodajRecenzję(this);
	}
	
	
	public String toString()
	{
		String join = new String();
	
		join+="\nOcena: " + this.ocena;
		
		join+="\nopis: " + this.opis;
		join+="\n--------------------------\n";
			return join;
		}

}
