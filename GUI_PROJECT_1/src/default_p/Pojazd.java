package default_p;

public class Pojazd extends Objekt  {

	
	double sizePojazdu;
public Pojazd(double wysokosc, double dlugosc_a, double dlugosc_b) {
		
		super(wysokosc,dlugosc_a,dlugosc_b);
		this.sizePojazdu = wysokosc*dlugosc_a*dlugosc_b;
	}

public double getSize(){
	return sizePojazdu;
}

}
