package default_p;

public abstract class Objekt {
	double wysokosc;
	double dlugosc_a;
	double dlugosc_b;
	
	Objekt(double wysokosc, double dlugosc_a,double dlugosc_b){this.wysokosc = wysokosc;
	this.dlugosc_a = dlugosc_a;
	this.dlugosc_b = dlugosc_b;}
	
	 double getSize(){
		 return wysokosc*dlugosc_a*dlugosc_b;
	 };

}
