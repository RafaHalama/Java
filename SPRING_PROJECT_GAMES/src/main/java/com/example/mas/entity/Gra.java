package com.example.mas.entity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;








@Entity (name = "Gra")
public class Gra {
	 @Id  
	  @GeneratedValue(strategy=GenerationType.AUTO)  
	  @Column(name="gra_id") 
	private long id;
	

public enum GameType {
	Unknown, SinglePlayer, MultiPlayer, SingleMultiPlayer
}
	
	String tytul;
	private Double cena;
	private int ilosc_sprzedanych_kopii;
	@OneToMany(mappedBy = "gra")
	private Set<Recenzja> recenzje = new HashSet<Recenzja>();  // asocjacja z atr
	
	@OneToMany(mappedBy = "gra",fetch = FetchType.EAGER)												
	private Set<Raport>raporty = new HashSet<Raport>();  // asocjacja z atr
	
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="gry",fetch = FetchType.EAGER)  
	private List<Nośnik> nośniki = new ArrayList<Nośnik>(); 	
	@Enumerated
	private GameType gameType;

	
	// SINGLEPLAYER
	private int dlugosc_kampanii;

	// MULTIPLAYER
	private int ilosc_serwerow;
	private int najwieksza_liczba_graczy; 
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	private Silnikgraficzny silnik; 
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER, optional = false)
	private Studio studio; 


	Gra(){
		
	}

	
	public GameType getMovieCategory() {
	return gameType;
	}
	public void setGameType(GameType gameType) {
	this.gameType = gameType;
	}


	public List<Nośnik> getNośniki() {
		return nośniki;
	}



	public void setNośniki(List<Nośnik> nośniki) {
		this.nośniki = nośniki;
	}



	public Silnikgraficzny getSilnik() {
		return silnik;
	}



	public void setSilnik(Silnikgraficzny silnik) {
		this.silnik = silnik;
	}



	public Studio getStudio() {
		return studio;
	}



	public void setStudio(Studio studio) {
		this.studio = studio;
	}



	private Gra(String tytul, Double cena, int ilosc_sprzedanych_kopii, String typ, Studio studio) {
		this.tytul = tytul;
		this.cena = cena;
		this.ilosc_sprzedanych_kopii = ilosc_sprzedanych_kopii;
		
		if(typ == "single"){
			this.setGameType(gameType.SinglePlayer);
			
		}
		if(typ == "multi"){
			this.setGameType(gameType.MultiPlayer);
			
		}
		if(typ =="single_multi"){
			this.setGameType(gameType.SingleMultiPlayer);
		}
		this.studio = studio;
		
	}
	
	public static Gra stworzGre(String tytul, Double cena, int ilosc_sprzedanych_kopii, String typ, Studio studio)throws Exception {
		if(studio==null) {
			throw new Exception ("Studio nie istnieje");
		}
		Gra g = new Gra( tytul,  cena,  ilosc_sprzedanych_kopii,  typ,  studio);
		
		try {
			studio.dodajGre(g);
		} catch (Exception e) {
			System.out.println("Nie mo�na dodac gry");
		}
		return g;
	}
	
	
	public Double getCena() {
		return cena;
		}
	
	public Double setCena() {
		return cena;
		}

	
	
	
	
	
	public int getIlosc_sprzedanych_kopii() {
		return ilosc_sprzedanych_kopii;
	}



	public void setIlosc_sprzedanych_kopii(int ilosc_sprzedanych_kopii) {
		this.ilosc_sprzedanych_kopii = ilosc_sprzedanych_kopii;
	}



	public long getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Gra [tytul=" + tytul + ", cena=" + cena + ", ilosc_sprzedanych_kopii=" + ilosc_sprzedanych_kopii
				+ ", dlugosc_kampanii=" + dlugosc_kampanii + ", ilosc_serwerow="
				+ ilosc_serwerow + ", najwieksza_liczba_graczy=" + najwieksza_liczba_graczy + "]";
	}

	public int hasKampania() throws Exception {
		if (gameType.equals(gameType.SinglePlayer) || gameType.equals(gameType.SingleMultiPlayer)) {
			return dlugosc_kampanii;
		}
		//throw new Exception("The game is not singleplayer!");
		return 0;
	}

	public void setKampania(int dlugosc_kampanii) throws Exception {
		if (gameType.equals(gameType.SinglePlayer) || gameType.equals(gameType.SingleMultiPlayer)) {
		this.dlugosc_kampanii = dlugosc_kampanii;
		}
		else {
			throw new Exception("The game is not singleplayer!");	
			}
	}
 ////////////////////////////////////////////////////////////////////////////////////////////////
	public int hasSerwery() throws Exception {
		if (gameType.equals(gameType.MultiPlayer) || gameType.equals(gameType.SingleMultiPlayer)) {
			return ilosc_serwerow;
		}
		//throw new Exception("The game is not multiplayer!");
		return 0;
	}

	public void setSerwery(int ilosc_serwerow) throws Exception {
		if (gameType.equals(gameType.MultiPlayer) || gameType.equals(gameType.SingleMultiPlayer)) {
		this.ilosc_serwerow = ilosc_serwerow;
		}
		else {
			throw new Exception("The game is not multiplayer!");		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int hasIloscGraczy() throws Exception {
		if (gameType.equals(gameType.MultiPlayer) || gameType.equals(gameType.SingleMultiPlayer)) {
			return najwieksza_liczba_graczy;
		}
		//throw new Exception("The game is not multiplayer!");
		return 0;
	}

	public void setIloscGraczy(int najwieksza_liczba_graczy) throws Exception {
		if (gameType.equals(gameType.MultiPlayer) || gameType.equals(gameType.SingleMultiPlayer)) {
		this.najwieksza_liczba_graczy = najwieksza_liczba_graczy;
		}
		else {
			throw new Exception("The game is not multiplayer!");		}
	}
	
	
	
	public void dodajNośnik(Nośnik nośnik) {
		if (!nośniki.contains(nośnik)) {
			nośniki.add(nośnik);

			nośnik.dodajGre(this); // informacja zwrotna
		}

	}
	public void usunNośnik(Nośnik nośnik) {
		if(nośniki.contains(nośnik)) {
			nośniki.remove(nośnik);
 
            // Remove the reverse link
			nośnik.usunGrę(this);
        }
    }
	

	public void dodajRecenzję(Recenzja recenzja) {
		if (!recenzje.contains(recenzja)) {
			recenzje.add(recenzja);

		}
	}

	public void dodajRaport(Raport raport) {
		if (!raporty.contains(raport)) {
			raporty.add(raport);

		}
	}

	

	public String getTytul() {
		return tytul;
	}



	public void setTytul(String tytul) {
		this.tytul = tytul;
	}



	public void dodajSilnik(Silnikgraficzny silnik) {
		if(this.silnik==null) {
		this.silnik = silnik;
		silnik.dodajGre(this);
		}
	}
	
	
}