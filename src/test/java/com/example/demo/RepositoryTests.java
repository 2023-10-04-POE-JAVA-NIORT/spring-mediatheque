package com.example.demo;

import com.example.demo.dao.entity.Adherent;
import com.example.demo.dao.entity.Document;
import com.example.demo.dao.entity.Emprunt;
import com.example.demo.dao.repository.AdherentRepository;
import com.example.demo.dao.repository.DocumentRepository;
import com.example.demo.dao.repository.EmpruntRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepositoryTests {

	@Autowired
	DocumentRepository documentRepository;

	@Autowired
	AdherentRepository adherentRepository;

	@Autowired
	EmpruntRepository empruntRepository;

	@Test
	void save() {
		Document document = new Document("Bambi", "anonyme");
		documentRepository.save(document);

		Adherent adherent = new Adherent("Jean-Christophe", "Dominguez");
		adherentRepository.save(adherent);

		Emprunt emprunt = new Emprunt();
		emprunt.setAdherent(adherent);
		emprunt.setDocument(document);
		empruntRepository.save(emprunt);
	}

}
