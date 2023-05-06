package com.example.mas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.mas.entity.Archiwista;
import com.example.mas.entity.ArchiwistaRecenzent;
import com.example.mas.entity.Nośnik;
import com.example.mas.service.NośnikRepository;
import com.example.mas.entity.Gra;
import com.example.mas.entity.Raport;
import com.example.mas.entity.Recenzja;
import com.example.mas.entity.Silnikgraficzny;
import com.example.mas.service.ArchiwistaRecenzentRepository;
import com.example.mas.service.ArchiwistaRepository;
import com.example.mas.service.GraRepository;
import com.example.mas.service.RaportRepository;
import com.example.mas.service.RecenzentRepository;
import com.example.mas.service.RecenzjaRepository;
import com.example.mas.service.SilnikgraficznyRepository;
import com.example.mas.entity.Studio;
import com.example.mas.service.StudioRepository;
@Component
public class ArchiwumRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ArchiwumRepositoryCommandLineRunner.class);
	
	@Autowired
	private NośnikRepository nośnikRepository;
	@Autowired
	private GraRepository graRepository;
	@Autowired
	private StudioRepository studioRepository;
	@Autowired
	private SilnikgraficznyRepository silnikRepository;
	@Autowired
	private ArchiwistaRepository archiwistaRepository;
	@Autowired
	private RecenzentRepository recenzentRepository;
	@Autowired
	private RecenzjaRepository recenzjaRepository;
	@Autowired
	private RaportRepository raportRepository;
	@Autowired
	private ArchiwistaRecenzentRepository archiwistaRecenzentRepository;
	@Override
	public void run(String... args) throws Exception {
		/*DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
			Date date = format.parse("1987/04/15");
		Nośnik nośnik = new Nośnik("Playstation 1", "Sony");
		Nośnik nośnik2 = new Nośnik("Playstation 2", "Sony");
		Nośnik nośnik3 = new Nośnik("Playstation 3", "Sony");
		Nośnik nośnik4 = new Nośnik("Xbox 360", "Microsoft");
		Nośnik nośnik5 = new Nośnik("Xbox 1", "Microsoft");
		Nośnik nośnik6 = new Nośnik("Nintendo Switch", "Nintendo");

		Studio studio = new Studio("CD Projekt", "Warszawa", 180);
		Studio studio2 = new Studio("Activision", "London", 2200);
		Studio studio3 = new Studio("EA Games", "Berlin", 5650);
		Studio studio4 = new Studio("Piranha Bytes", "Berlin", 85);
		Studio studio5 = new Studio("Riot Games", "California", 3420);
		Studio studio6 = new Studio("Valve", "Helsinki", 1780);
		Studio studio7 = new Studio("Rockstar Games", "San Francisco", 2100);
		
		Gra gra = Gra.stworzGre("Wiedzmin 1", 100.0, 2000000, "single", studio);
		Gra gra1 = Gra.stworzGre("Wiedzmin 2", 150.0, 6000000, "single", studio);
		Gra gra2 = Gra.stworzGre("Battlefield 1", 150.0, 10000000, "single_multi", studio3);
		Gra gra3 = Gra.stworzGre("League of Legends", 150.0, 18000000, "multi", studio5);
		Gra gra4 = Gra.stworzGre("Dota 2", 150.0, 3000000, "multi", studio6);
		Gra gra5 = Gra.stworzGre("Call of Duty:Black Ops", 150.0, 12000000, "single_multi", studio2);
		Gra gra6 = Gra.stworzGre("Gothic", 150.0, 100000, "single", studio4);
		Gra gra7 = Gra.stworzGre("Gothic 2", 150.0, 200000, "single", studio4);
		Gra gra8 = Gra.stworzGre("Grand Theft Auto 5", 150.0, 33000000, "single_multi", studio7);
		Gra gra9 = Gra.stworzGre("Read Dead Redemption", 150.0, 8000000, "single", studio7);

	
		gra.setKampania(55);
		gra1.setKampania(67);
		
		gra2.setIloscGraczy(500000);
		gra2.setSerwery(14);
		gra2.setKampania(23);
		
		gra3.setIloscGraczy(222125);
		gra3.setSerwery(24);

		gra4.setIloscGraczy(200000);
		gra4.setSerwery(31);
		
		gra5.setIloscGraczy(1000000);
		gra5.setSerwery(58);
		gra5.setKampania(14);
		
		gra6.setKampania(78);
		
		gra7.setKampania(22);
		
		gra8.setIloscGraczy(570000);
		gra8.setSerwery(11);
		gra8.setKampania(26);

		gra9.setKampania(124);

		
		Silnikgraficzny silnik = new Silnikgraficzny("Unreal Engine", "BioWare", 1.36);
		Silnikgraficzny silnik2 = new Silnikgraficzny("FrostBite", "EA DICE", 1.12);
		Silnikgraficzny silnik3 = new Silnikgraficzny("Unity", "Unity", 2.33);

		silnik.dodajGre(gra);
		silnik.dodajGre(gra1);
		silnik2.dodajGre(gra2);
		silnik2.dodajGre(gra3);
		silnik2.dodajGre(gra4);
		silnik3.dodajGre(gra5);
		silnik3.dodajGre(gra6);
		silnik3.dodajGre(gra7);
		silnik3.dodajGre(gra8);
		silnik3.dodajGre(gra9);
		
		nośnik.dodajGre(gra);
		nośnik2.dodajGre(gra);
		nośnik.dodajGre(gra1);
		nośnik2.dodajGre(gra1);
		nośnik3.dodajGre(gra1);
		nośnik5.dodajGre(gra2);
		nośnik4.dodajGre(gra2);
		nośnik3.dodajGre(gra3);
		nośnik2.dodajGre(gra3);
		nośnik2.dodajGre(gra4);
		nośnik2.dodajGre(gra4);
		nośnik4.dodajGre(gra5);
		nośnik5.dodajGre(gra6);
		nośnik6.dodajGre(gra6);
		nośnik6.dodajGre(gra7);
		nośnik3.dodajGre(gra8);
		nośnik4.dodajGre(gra8);
		nośnik.dodajGre(gra9);
		nośnik2.dodajGre(gra9);
		nośnik3.dodajGre(gra9);
		nośnik4.dodajGre(gra9);
		nośnik5.dodajGre(gra9);


		
		Archiwista archiwista = new Archiwista("Jedrzej", "Baran", date,"663 166 218", 5000);
		Archiwista archiwista2 = new Archiwista("Aneta", "Baran", date,"667 333 222", 5000);
		ArrayList<String> pop = new ArrayList<String>();
	
		ArchiwistaRecenzent ar = new ArchiwistaRecenzent("Jedrzej", "Baran", date,"663 166 218", 5000, "wp.pl", 3000,"euro");
		Raport raport = new Raport(date, "opis", gra, archiwista);
		Raport raport2 = new Raport(date, "opis", gra, archiwista2);

		Recenzja recenzja = new Recenzja(8.6, "fajna", gra, ar, date);
		
		
		gra.dodajRaport(raport);
		nośnikRepository.save(nośnik);
		nośnikRepository.save(nośnik2);
		nośnikRepository.save(nośnik3);
		nośnikRepository.save(nośnik4);
		nośnikRepository.save(nośnik5);
		nośnikRepository.save(nośnik6);

		graRepository.save(gra);
		graRepository.save(gra1);
		graRepository.save(gra2);
		graRepository.save(gra3);
		graRepository.save(gra4);
		graRepository.save(gra5);
		graRepository.save(gra6);
		graRepository.save(gra7);
		graRepository.save(gra8);
		graRepository.save(gra9);
		studioRepository.save(studio);
		studioRepository.save(studio2);
		studioRepository.save(studio3);
		studioRepository.save(studio4);
		silnikRepository.save(silnik);
		silnikRepository.save(silnik2);
		silnikRepository.save(silnik3);
		archiwistaRepository.save(archiwista);
		archiwistaRepository.save(archiwista2);
		raportRepository.save(raport);
		raportRepository.save(raport2);
		archiwistaRecenzentRepository.save(ar);
		recenzjaRepository.save(recenzja);
		log.info("Nowy nośnik został stworzony: " + nośnik);
		log.info("Nowy nośnik został stworzony: " + nośnik2);
		log.info("Nowa Gra został stworzony: " + gra);
		log.info("Nowa Gra został stworzony: " + gra1);
		log.info("Nowe Studio został stworzony: " + studio);
		log.info("Nowe Silnik został stworzony: " + silnik);
		log.info("Nowe archiwista został stworzony: " + archiwista);
		log.info("Nowe archiwista został stworzony: " + archiwista2);
		log.info("Nowe raport został stworzony: " + raport);
		log.info("Nowe raport został stworzony: " + raport2);*/

	}

	
}
