package com.example.mas;

import com.example.mas.entity.ArchiwistaRecenzent;
import com.example.mas.entity.Gra;
import com.example.mas.entity.Nośnik;
import com.example.mas.entity.Studio;
import com.example.mas.service.GraRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MasApplicationTests {
	private Gra gameTest;
	private Studio studioTest;
	private ArchiwistaRecenzent arTest;
	@AfterEach
	void tearDown(){
		gameTest=null;
		studioTest=null;
		arTest=null;
	}
	@Test
	void AddingSameGameTwiceTest() throws Exception {

		studioTest = new Studio("CD Projekt", "Warszawa", 180);
		gameTest = Gra.stworzGre("Wiedzmin 1", 100.0, 2000000, "single", studioTest);
		assertThrows(Exception.class, ()-> studioTest.dodajGre(gameTest));
	}
	@Test
	void studioNullTest(){
		assertThrows(Exception.class, () -> Gra.stworzGre("test", 10.0d, 1, (String) "single", null));
	}

	@Test
	void AddMultipleNosnikTest() throws Exception {
		List<Nośnik> nosnik = List.of(new Nośnik("t1", "x1"),
				new Nośnik("t2", "x2"),
				new Nośnik("t3", "x3"));
		studioTest = new Studio("CD Projekt", "Warszawa", 180);
		gameTest = Gra.stworzGre("Wiedzmin 1", 100.0, 2000000, "single", studioTest);

		for(Nośnik n:nosnik) gameTest.dodajNośnik(n);
		assertEquals(gameTest.getNośniki().size(),3);
	}
	@Test
	void ArchiwistaRecenzentSalaryTest() throws Exception {
		arTest = new ArchiwistaRecenzent("x", "x", null,"1", 5000, "x", 3000,"euro");
		assertThat(arTest.getPensjaBrutto()).isEqualTo(5000*1.23);
		assertThat(arTest.getPensjaArchiwisty()).isEqualTo(3000*1.23);
		assertThat(arTest.getDochody()).isEqualTo(3000*1.23 + 5000*1.23);
	}

}
