package com.example.demo;

import com.example.demo.dao.entity.Adherent;
import com.example.demo.dao.entity.Document;
import com.example.demo.metier.DemandeEmpruntStatut;
import com.example.demo.metier.Mediatheque;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UnitTests {

	@Test
	void testCanEmprunter() {
		Document document = new Document();
		Adherent adherent = new Adherent();

		assertEquals(DemandeEmpruntStatut.ACCEPTE,
				Mediatheque.canEmprunter(adherent, document));
	}

	@Test
	void testCanEmprunterAdhesionPerimee(){
		Document document = new Document();
		Adherent adherent = new Adherent();
		adherent.setFinAdhesion(LocalDate.now().minusDays(1));

		assertEquals(DemandeEmpruntStatut.REFUSE_ADHESION_PERIMEE
				, Mediatheque.canEmprunter(adherent, document));
	}

	@Test
	void testCanEmprunterDocumentNonDisponible(){
		Document document = new Document();
		document.setEmprunte(true);

		Adherent adherent = new Adherent();

		assertEquals(DemandeEmpruntStatut.REFUSE_DOCUMENT_NON_DISPONIBLE,
				Mediatheque.canEmprunter(adherent, document));
	}

	@Test
	void testCanEmprunterNombreEmpruntMax(){
		Adherent adherent = new Adherent();

		Mediatheque.realiseEmprunt(adherent, new Document());
		Mediatheque.realiseEmprunt(adherent, new Document());
		Mediatheque.realiseEmprunt(adherent, new Document());

		assertEquals(DemandeEmpruntStatut.REFUSE_QUOTA_ATTEINT,
				Mediatheque.canEmprunter(adherent, new Document()));
	}
}
