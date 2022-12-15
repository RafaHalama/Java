package default_p;



public class Motocykl extends Pojazd {
	boolean czyMaHomologacje;
	
	public Motocykl(double wysokosc, double dlugosc_a, double dlugosc_b,boolean czyMaHomologacje) {
		super(wysokosc, dlugosc_a, dlugosc_b);
		this.czyMaHomologacje=czyMaHomologacje;
		
	}

}
