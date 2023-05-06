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
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
			Date date = format.parse("1987/04/15");
		Nośnik nośnik = new Nośnik("Playstation 1", "PlayStation");
		Nośnik nośnik2 = new Nośnik("Playstation 2", "PlayStation");

		Studio studio = new Studio("CD Projekt", "Warszawa", 2000);
		Gra gra = Gra.stworzGre("Wiedzmin 1", 100.0, 2000000, "multi", studio);
		Gra gra1 = Gra.stworzGre("Wiedzmin 2", 150.0, 6000000, "single_multi", studio);
		gra.setIloscGraczy(500000);
		gra.setSerwery(14);
		Silnikgraficzny silnik = new Silnikgraficzny("Unreal Engine", "BioWare", 1.36);
		silnik.dodajGre(gra);
		silnik.dodajGre(gra1);
		nośnik.dodajGre(gra);
		nośnik2.dodajGre(gra1);
		gra.dodajNośnik(nośnik2);
		Archiwista archiwista = new Archiwista("Jedrzej", "Baran", date,"663 166 218", 5000);
		Archiwista archiwista2 = new Archiwista("Jedrzej", "Barana", date,"663 166 218", 5000);
		ArrayList<String> pop = new ArrayList<String>();
	
		ArchiwistaRecenzent ar = new ArchiwistaRecenzent("Jedrzej", "Baran", date,"663 166 218", 5000, "wp.pl", 3000,"euro");
		Raport raport = new Raport(date, "opis", gra, archiwista);
		Raport raport2 = new Raport(date, "opis", gra, archiwista2);

		Recenzja recenzja = new Recenzja(8.6, "fajna", gra, ar, date);
		
		
		gra.dodajRaport(raport);
		nośnikRepository.save(nośnik);
		nośnikRepository.save(nośnik2);
		graRepository.save(gra);
		graRepository.save(gra1);
		studioRepository.save(studio);
		silnikRepository.save(silnik);
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
		log.info("Nowe raport został stworzony: " + raport2);

	}

	
}
