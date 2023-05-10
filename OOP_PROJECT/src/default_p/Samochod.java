package default_p;

public class Samochod extends Pojazd {
	
	enum Rodzaj{
		DIESEl,BENZYNA,GAZ,HYBRYDA
	}
	Rodzaj rodzaj;
	double pojemnoscSilnika;

	public Samochod(double wysokosc, double dlugosc_a, double dlugosc_b,Rodzaj r,double pojemnoscSilnika) {
		super(wysokosc, dlugosc_a, dlugosc_b);
		this.rodzaj=r;
		this.pojemnoscSilnika=pojemnoscSilnika;
		
	}

	

}
