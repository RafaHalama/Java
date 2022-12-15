import java.util.ArrayList;
import java.util.Date;

public class ArchiwistaRecenzent extends Recenzent implements IArchiwista {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String firma = "Archiwum gier komputerowych ARK"; 
	private ArrayList<String> poprzednieMiejscaPracy = new ArrayList<String>(); 
	private double pensja;
	final static double stawkaVat = 1.23; 
    
    public ArchiwistaRecenzent(String imie, String nazwisko, Date dataUrodzenia, String nrtelefonu, double pensja, String serwis, int pensja2, ArrayList<String> poprzednie) {
        super(imie, nazwisko, dataUrodzenia,nrtelefonu, pensja, serwis);
 
        this.pensja = pensja2;
        this.poprzednieMiejscaPracy = poprzednie;
    }
 
    
    
    public double getPensjaArchiwisty() {
        return pensja * stawkaVat;
    }
 
    
    public double getDochody() {
        return super.getPensjaNetto() + getPensjaArchiwisty();
    }
 
    public String getFirmy() {
        return firma + " " + super.getFirma();
    }



	@Override
	public ArrayList<String> getPoprzednieMiejscaPracy() {
		return poprzednieMiejscaPracy;
	}
}