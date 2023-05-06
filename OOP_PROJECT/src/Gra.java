import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
//rodzaj rozgrywki
enum GameType {
	Game, SinglePlayer, MultiPlayer
};



public class Gra extends ObjectPlus {
	//rodzaj grafiki
	boolean czy2D;
	boolean czy3D;
	
	
	
	private static final long serialVersionUID = 1L;

	String tytul;
	private Double cena;
	private int ilosc_sprzedanych_kopii;
	private ArrayList<Recenzja> recenzje = new ArrayList<Recenzja>(); // asocjacja
																		// z
																		// atrybutem
	private Raport raport;
	private ArrayList<Raport> raporty = new ArrayList<Raport>(); // kwalifikowana
	private ArrayList<Nośnik> nośniki = new ArrayList<Nośnik>(); // binarna

	private EnumSet<GameType> gameKind = EnumSet.<GameType>of(GameType.Game);
	// SINGLEPLAYER
	private int dlugosc_kampanii;

	// MULTIPLAYER
	private int ilosc_serwerow;
	private int najwieksza_liczba_graczy; 
	
	//2D
	private String costam;
	
	//3D
	private String rodzajKamery;
	
	
	
	public void setKamera(String x){
		if(czy3D){
			rodzajKamery = x;
		}
	}
	public String getKamera() throws Exception {
		if(czy3D){
			return rodzajKamery;
		}
		throw new Exception("The game is not 2D!");
	}
	
	public void set2D(String x){
		if(czy2D){
			costam = x;
		}
	}
	public String get2D() throws Exception {
		if(czy2D){
			return costam;
		}
		throw new Exception("The game is not 2D!");
	}
	
	
	
	public int hasKampania() throws Exception {
		if (gameKind.contains(GameType.SinglePlayer)) {
			return dlugosc_kampanii;
		}
		throw new Exception("The game is not singleplayer!");
	}

	public void setKampania(int dlugosc_kampanii) throws Exception {
		if(gameKind.contains(GameType.SinglePlayer)) {
		this.dlugosc_kampanii = dlugosc_kampanii;
		}
		else {
			throw new Exception("The game is not singleplayer!");		}
	}
 ////////////////////////////////////////////////////////////////////////////////////////////////
	public int hasSerwery() throws Exception {
		if (gameKind.contains(GameType.MultiPlayer)) {
			return ilosc_serwerow;
		}
		throw new Exception("The game is not multiplayer!");
	}

	public void setSerwery(int ilosc_serwerow) throws Exception {
		if(gameKind.contains(GameType.MultiPlayer)) {
		this.ilosc_serwerow = ilosc_serwerow;
		}
		else {
			throw new Exception("The game is not multiplayer!");		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int hasIloscGraczy() throws Exception {
		if (gameKind.contains(GameType.MultiPlayer)) {
			return najwieksza_liczba_graczy;
		}
		throw new Exception("The game is not multiplayer!");
	}

	public void setIloscGraczy(int najwieksza_liczba_graczy) throws Exception {
		if(gameKind.contains(GameType.MultiPlayer)) {
		this.najwieksza_liczba_graczy = najwieksza_liczba_graczy;
		}
		else {
			throw new Exception("The game is not multiplayer!");		}
	}
	
	
	
	Gra(String tytul, Double cena, int ilosc_sprzedanych_kopii, String typ, String grafika) {
		this.tytul = tytul;
		this.cena = cena;
		this.ilosc_sprzedanych_kopii = ilosc_sprzedanych_kopii;
		
		if(typ == "single"){
			gameKind = EnumSet.<GameType>of(GameType.SinglePlayer);
			
		}
		if(typ == "multi"){
			gameKind = EnumSet.<GameType>of(GameType.MultiPlayer);
			
		}
		if(typ =="single_multi"){
			gameKind = EnumSet.of(GameType.SinglePlayer, GameType.MultiPlayer);

		}
		if(grafika == "2D"){
			czy2D = true;
		}
		if(grafika =="3D"){
			czy3D = true;
		}
		// TODO Auto-generated constructor stub
	}

	
	public void getGameType(){
	      System.out.println(gameKind); 
	}
	
	public void dodajNośnik(Nośnik nośnik) {
		if (!nośniki.contains(nośnik)) {
			nośniki.add(nośnik);

			nośnik.dodajGre(this); // informacja zwrotna
		}

	}

	public void usunNośnik(Nośnik nośnik) {
		if (nośniki.contains(nośnik)) {
			nośniki.remove(nośnik);

			nośnik.usunGre(this); // informacja zwrotna
		}
	}

	public void dodajRecenzję(Recenzja recenzja) {
		if (!recenzje.contains(recenzja)) {
			recenzje.add(recenzja);

		}
	}

	public void dodajRaport(Raport raport) {
		if (this.raport == null) {
			this.raport = raport;
			raport.dodajGre(this);
		}
	}

	public String toString() {
		String join = new String();

		join += "\nTytuł: " + this.tytul;

		join += "\ncena: " + this.cena;

		join += "\nIlość Sprzedanych Kopii: " + this.ilosc_sprzedanych_kopii;

		join += "\nNośniki: ";
		for (Nośnik s : nośniki) {
			join += "\n" + s.nazwa;
		}
		join += "\n--------------------------\n";

		return join;
	}

}
