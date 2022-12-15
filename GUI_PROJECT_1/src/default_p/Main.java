package default_p;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) throws IOException {
		List<Osoba> listaOsob = new ArrayList<>();
		List<Pomieszczenie> listaPomieszczen = new ArrayList<>();
		List<Pomieszczenie> listaPomieszczenNaSamochody = new ArrayList<>();
		List<Pomieszczenie> listaPomieszczenPrzedmioty = new ArrayList<>();
		
		Pomieszczenie naS1 = new NaSamochody(5.0,6.0,7.0);
		listaPomieszczen.add(naS1); 
		listaPomieszczenNaSamochody.add(naS1);
		Pomieszczenie naS2 = new NaSamochody(6.0,6.0,7.0);
		listaPomieszczen.add(naS2); 
		listaPomieszczenNaSamochody.add(naS2);
		Pomieszczenie naS3 = new NaSamochody(7.0,6.0,7.0);
		listaPomieszczen.add(naS3); 
		listaPomieszczenNaSamochody.add(naS3);
		Pomieszczenie naS4 = new NaSamochody(8.0,6.0,7.0);
		listaPomieszczen.add(naS4); 
		listaPomieszczenNaSamochody.add(naS4);
		Pomieszczenie naS5 = new NaSamochody(9.0,6.0,7.0);
		listaPomieszczen.add(naS5); 
		listaPomieszczenNaSamochody.add(naS5);
		Pomieszczenie naS6 = new NaSamochody(5.0,4.0,3.0);
		listaPomieszczen.add(naS6); 
		listaPomieszczenNaSamochody.add(naS6);
		Pomieszczenie naP1 = new NaPrzedmioty(4.0,5.0,7.0);
		listaPomieszczen.add(naP1); 
		listaPomieszczenPrzedmioty.add(naP1);
		Pomieszczenie naP2 = new NaPrzedmioty(5.0,5.0,7.0);
		listaPomieszczen.add(naP2); 
		listaPomieszczenPrzedmioty.add(naP2);
		Pomieszczenie naP3 = new NaPrzedmioty(6.0,5.0,7.0);
		listaPomieszczen.add(naP3); 
		listaPomieszczenPrzedmioty.add(naP3);
		Pomieszczenie naP4 = new NaPrzedmioty(7.0,5.0,7.0);
		listaPomieszczen.add(naP4); 
		listaPomieszczenPrzedmioty.add(naP4);
		Pomieszczenie naP5 = new NaPrzedmioty(8.0,5.0,7.0);
		listaPomieszczen.add(naP5); 
		listaPomieszczenPrzedmioty.add(naP5);
		Osoba os1 = new Osoba("Jan", "Kowalski", "80112200111", "Warszawa, Ulicowa 5", "1980-11-22", LocalDate.of(2000, 05, 01));
		listaOsob.add(os1);
		Osoba os2 = new Osoba("Janusz", "Nowak", "81112200111", "Warszawa, Ulicowa 5", "1981-11-22", LocalDate.of(2000, 05, 01));
		listaOsob.add(os2);
		Osoba os3 = new Osoba("Buba", "Kerlinski", "82112200111", "Warszawa, Ulicowa 5", "1982-11-22", LocalDate.of(2000, 05, 01));
		listaOsob.add(os3);
		Osoba os4 = new Osoba("Andrzej", "Grabowski", "79112200111", "Warszawa, Ulicowa 5", "1979-11-22", LocalDate.of(2000, 05, 01));
		listaOsob.add(os4);
		Osoba os5 = new Osoba("Jaroslaw", "Boberek", "78112200111", "Warszawa, Ulicowa 5", "1978-11-22", LocalDate.of(2000, 05, 01));
		listaOsob.add(os5);
		Osoba os6 = new Osoba("Tomasz", "Knapik", "77112200111", "Warszawa, Ulicowa 5", "1977-11-22", LocalDate.of(2000, 05, 01));
		listaOsob.add(os6);
		os1.addToList(naS1,2,LocalDate.of(2018, 04, 01));
		os1.addToList(naS3,2000,LocalDate.of(2018, 04, 01));
		os1.addToList(naP1,2000,LocalDate.of(2018, 03, 01));
		os2.addToList(naP2,2000,LocalDate.of(2018, 02, 01));
		os3.addToList(naS2,2000,LocalDate.of(2018, 01, 01));
		os4.addToList(naP3,2000,LocalDate.of(2017, 05, 01));
		os5.addToList(naP5,20000,LocalDate.of(2016, 05, 01));
		
		Objekt o1 = new Motocykl(2.0,2.0,1.0,true);
		Objekt o2 = new Motocykl(1.0,2.0,1.0,true);
		
		try {
			naS1.wlozPojazd(o1);
			naS1.wlozPojazd(o2);
		} catch (TooManyThingsException e1) {
			
			e1.printStackTrace();
		}
		System.out.println(naS1.listaPojazdow);
		System.out.println(naS3.listaPojazdow);
		//p1.listaPojazdow.add(ob);
		//p.listaPojazdow.remove(ob);
		//o.listaPomieszczen.remove(p);
		
		
		
	/*	ListIterator<Osoba> l1 = listaOsob.listIterator();
		while(l1.hasNext()){
			ListIterator<Pomieszczenie> l2 = l1.next().getLista().listIterator();
			while(l2.hasNext()){				
			
			if(LocalDate.now().isAfter(l2.next().ld)){
				if(l2.next().name().equals("NaSamochody")){
				ListIterator<Pomieszczenie> l21 = l1.next().getLista().listIterator();
				while(l21.hasNext()){
					if(!l21.next().equals(l2.next())){
						if(l21.next().name().equals("NaSamochody")){
							ListIterator<Objekt> l3 = l2.next().getListaPojazdow().listIterator();
							while(l2.hasNext()){
								if(l21.next().getRemainingSpace()>l3.next().getSize()){
									l21.next().listaPojazdow.add(l3.next());
									l2.next().listaPojazdow.remove(l3.next());
								}
							}
						}
						
					}
				}
				
			}l1.next().listaPomieszczen.remove(l2.next());
			}
			}
		}
		
		*/
		
		for(Osoba x: listaOsob){
			List<Pomieszczenie> list = x.getLista();
			for(Pomieszczenie p :list ){
				
				if(LocalDate.now().isAfter(p.ld)){
					if(p.name().equals("NaSamochody")){
						
						for(Pomieszczenie p1 :list){
							if(!p1.equals(p)){
							if(p1.name().equals("NaSamochody")){
								Iterator<Objekt> iter = p.getListaPojazdow().iterator();
								while(iter.hasNext()){
									Objekt ob = iter.next();
									if(p1.getRemainingSpace()> ob.getSize()){
										p.listaPojazdow.remove(ob);
									}
								}
							}
						}
						}/*x.listaPomieszczen.remove(p);/*
					}else if(p.name().equals("NaPrzedmioty")){
						for(Pomieszczenie p1 : o.getLista()){
							if(!p1.equals(p)){
							if(p1.name().equals("NaPrzedmioty")){
								for(Objekt ob : p.listaPrzedmiotow){
									if(p1.getRemainingSpace()> ob.getSize()){
										//p1.listaPrzedmiotow.add(ob);
										//p.listaPrzedmiotow.remove(ob);
									}
								}
							}
							}
						}//o.listaPomieszczen.remove(p);
					}
				}
			}*/}
					}
		}
			
		}
		
		
		StringBuilder sb= new StringBuilder();
		
		for(Osoba o : listaOsob){
			sb.append(o.imie + " "+ o.nazwisko + " posiada pomieszczenia o numerach : ");
			for(Pomieszczenie p : o.getLista()){
				sb.append(p.number + " ");
				
				if(p.name().equals("NaSamochody")){
				sb.append("w ktorym sa: ");
					for(Objekt po : p.getListaPojazdow()){
						sb.append(po + " ");
					}
				}	
				if(p.name().equals("NaPrzedmioty")){
					sb.append("w ktorym sa : ");
					for(Objekt po : p.getListaPrzedmiotow()){
						sb.append(po + " ");
					}
				}	
			}
			sb.append(System.getProperty("line.separator"));
		}
		File file = new File("stanMagazynu.txt");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		    try {
				writer.write(sb.toString());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
boolean exit = false;
		
		while(!exit){
			Scanner sc = new Scanner(System.in);

			System.out.println("\nWybierz numer opcji (1-4):");
			System.out.println("1. Wybierz ktora chcesz byc osoba");
			System.out.println("2. Wyswietl pomieszczenia tej osoby");
			System.out.println("3. Wyswietl wolne pomieszczenia");
			System.out.println("4. Wynajmij");
			System.out.println("5. Sprawdz zawartosc pomieszczenia");
			System.out.println("6. Wloz");
			System.out.println("7. Wyjmij");
			System.out.println("8. Wyjdz");
			
			int chosenOption = 0;		
			int chose=0;
			try{
				chosenOption = sc.nextInt();
				
				switch(chosenOption){
					case 1:
						
						
						Scanner sc2 = new Scanner(System.in);
						chose = sc2.nextInt();
						System.out.println("chose to : " + chose);
						
						System.out.println("Imie: " + listaOsob.get(chose).imie + " Nazwisko: " + listaOsob.get(chose).nazwisko);
						
						
						
					break;
					
					case 2:
						
						System.out.println("chose to : " + chose);
						System.out.println("Posiadane pomieszczenia: " );
						for(Pomieszczenie p : listaOsob.get(chose).getLista()){
							System.out.print(p.number + " ");
						}
					break;
					
					case 3:
						for(Pomieszczenie p : listaPomieszczen){
							if(p.o == null){
								System.out.println("pomieszczenie o numerze : " + p.number + " jest wolne" );
							}
						}
						
					break;
					
					case 4:
						System.out.println("Wprowadz numer pomieszczenia i ilosc dni na ktore chcesz wynajac rozdzielone przecinkiem");
						Scanner sc3 = new Scanner(System.in);
						
						
						
						String characteristicsString = sc3.nextLine();
						String[] characteristics = characteristicsString.split(",");
						
						int num =Integer.parseInt(characteristics[0]) ;
						int dni = Integer.parseInt(characteristics[1]);
						
						Pomieszczenie pp= listaPomieszczen.get(num);
						listaOsob.get(chose).addToList(pp,dni,LocalDate.now());
					break;
					
					case 5:
						int choser=0;
						System.out.println("Posiadane pomieszczenia: " );
						for(Pomieszczenie p : listaOsob.get(choser).getLista()){
							System.out.print(p.number + " ");
						}System.out.println("Wybierz pomieszczenie ktore zawartosc chcesz wyswietlic");
						Scanner sc4 = new Scanner(System.in);
						int chooseRoom = sc4.nextInt();
						sc4.close();
						if(listaPomieszczen.get(chooseRoom).name().equals("NaSamochody")){
						//	for(Pojazd p :listaPomieszczenNaSamochody.get(chooseRoom).listaPojazdow)
						}else if(listaPomieszczen.get(chooseRoom).name().equals("NaPrzedmioty")){
							
						}
					break;
					
					case 6:
						//naS1.wloz();
						break;
					
					case 7:
						break;
						
					case 8 : 
						exit = true;
						break;
					default:
						
						System.out.println("Wpisano niepoprawna wartosc!\n");
				}
			}
			catch(NumberFormatException e){
				e.printStackTrace();
				System.out.println("Wpisano niepoprawna wartosc!\n");
			}
			
		}
		
		
	

		/*LocalDate ldt =  LocalDate.of(2018,04,15);
		System.out.println(ldt);
		System.out.println(ldt.getDayOfYear());
		System.out.println(ldt.plusDays(7));
		
		LocalDate ldtNOW =LocalDate.now();
		System.out.println(ldtNOW);
		System.out.println(ldtNOW.getDayOfYear());*/
		
		
		

	}

}
