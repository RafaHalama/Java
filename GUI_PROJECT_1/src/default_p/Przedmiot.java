package default_p;

public class Przedmiot extends Objekt {
	
	String coToJest;
	 //CoToJest c;
	 
	 
//	 enum CoToJest{
	//	 SAMOCHOD,MOTOCYKL,ROWER,INNY
	// }
	public Przedmiot(double wysokosc, double dlugosc_a, double dlugosc_b,String coToJest ) {
		super(wysokosc,dlugosc_a,dlugosc_b);
		
		this.coToJest = coToJest;
	}
	
	void changeSize(double wys, double dl_a,double dl_b){
		this.wysokosc=wys;
		this.dlugosc_a=dl_a;
		this.dlugosc_b = dl_b;
		
	}	
	double getSize(){
		return wysokosc*dlugosc_a*dlugosc_b;
	}
	
	public String toString(){
		return "przedmiot o nazwie : "+ coToJest + " o wymiarach: "+ wysokosc+" " + dlugosc_a +" " + dlugosc_b;
	}
	
	

}
