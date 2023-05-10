package default_p;

public class Rower extends Pojazd {

	int iloscPrzerzutek;
	boolean czyAmortyzowany;
	int iloscAmortyzatorow;
	TypHamulca tH;
	enum TypHamulca{
		tarczowy,zaciskowy
	}
	public Rower(double wysokosc, double dlugosc_a, double dlugosc_b,int iloscPrzerzutek,boolean czyAmortyzowany,int iloscAmortyzatorow,TypHamulca th) {
		super(wysokosc, dlugosc_a, dlugosc_b);
		this.iloscPrzerzutek=iloscPrzerzutek;
		this.czyAmortyzowany=czyAmortyzowany;
		this.tH=th;
		if(czyAmortyzowany==true)
			this.iloscAmortyzatorow=iloscAmortyzatorow;
		else
			this.iloscAmortyzatorow=0;
		
	}

}
