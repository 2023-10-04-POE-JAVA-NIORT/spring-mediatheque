package com.example.demo;

import com.example.demo.dao.entity.Adherent;
import com.example.demo.dao.entity.Document;
import com.example.demo.metier.Mediatheque;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UnitTests {

	@Test
	void testCanEmprunter() {
		Document document = new Document();
		Adherent adherent = new Adherent();

		assertTrue(Mediatheque.canEmprunter(adherent, document));
	}

	@Test
	void testCanEmprunterAdhesionPerimee(){
		Document document = new Document();
		Adherent adherent = new Adherent();
		adherent.setFinAdhesion(LocalDate.now().minusDays(1));

		assertFalse(Mediatheque.canEmprunter(adherent, document));
	}

	@Test
	void testCanEmprunterDocumentNonDisponible(){
		Document document = new Document();
		document.setEmprunte(true);

		Adherent adherent = new Adherent();

		assertFalse(Mediatheque.canEmprunter(adherent, document));
	}

	@Test
	void testCanEmprunterNombreEmpruntMax(){
		Adherent adherent = new Adherent();

		Mediatheque.realiseEmprunt(adherent, new Document());
		Mediatheque.realiseEmprunt(adherent, new Document());
		Mediatheque.realiseEmprunt(adherent, new Document());

		assertFalse(Mediatheque.canEmprunter(adherent, new Document()));
	}
}
