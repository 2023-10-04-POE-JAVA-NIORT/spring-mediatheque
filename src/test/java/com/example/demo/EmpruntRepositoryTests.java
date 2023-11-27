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

import java.util.List;
import java.util.Optional;

@SpringBootTest
class EmpruntRepositoryTests {

	@Autowired
	EmpruntRepository empruntRepository;

	@Autowired
	AdherentRepository adherentRepository;

	@Test
	void testfindAllByAdherent() {
		Optional<Adherent> optional = adherentRepository.findById(2);
		if(optional.isPresent()){
			Adherent adherent = optional.get();
			List<Emprunt> emprunts = empruntRepository.findAllByAdherent(adherent);
			System.out.println("Nombre emprunts : "+emprunts.size());
		}
	}

	@Test
	void testcountByAdherent() {
		Optional<Adherent> optional = adherentRepository.findById(2);
		if(optional.isPresent()){
			Adherent adherent = optional.get();
			int nombre = empruntRepository.countByAdherent(adherent);
			System.out.println("Nombre emprunts : "+nombre);
		}
	}

	@Test
	void testcountNativeQuery(){

		int nombre = empruntRepository.countNativeQuery(2);
		System.out.println("Nombre emprunts : "+nombre);
	}

	@Test
	void testcountQuery(){
		Optional<Adherent> optional = adherentRepository.findById(2);
		if(optional.isPresent()) {
			Adherent adherent = optional.get();
			int nombre = empruntRepository.countQuery(adherent);
			System.out.println("Nombre emprunts : " + nombre);
		}
	}
}
