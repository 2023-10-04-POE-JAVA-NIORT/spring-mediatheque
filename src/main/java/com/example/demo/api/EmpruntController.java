package com.example.demo.api;

import com.example.demo.dao.entity.Adherent;
import com.example.demo.dao.entity.Document;
import com.example.demo.dao.entity.Emprunt;
import com.example.demo.metier.DemandeEmpruntStatut;
import com.example.demo.metier.Mediatheque;
import com.example.demo.metier.MediathequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpruntController {

    @Autowired
    MediathequeService mediathequeService;

    @GetMapping("emprunts")
    public List<Emprunt> getAll(){
        return mediathequeService.getEmprunts();
    }

    @PostMapping("emprunts")
    public ResponseEntity addEmprunt(@RequestBody Emprunt empruntJSON){
        Optional<Document> documentOptional = mediathequeService.getDocumentById(empruntJSON.getDocument().getId());
        if(documentOptional.isEmpty())
            return ResponseEntity.badRequest().body("Document inexitant");

        Optional<Adherent> adherentOptional = mediathequeService.getAdherentById(empruntJSON.getAdherent().getId());
        if(adherentOptional.isEmpty())
            return ResponseEntity.badRequest().body("Adherent inexitant");


        Adherent adherentFromDatabase = adherentOptional.get();
        Document documentFromDatabase = documentOptional.get();
        DemandeEmpruntStatut statut = Mediatheque.canEmprunter(adherentFromDatabase, documentFromDatabase);
        if(statut.equals(DemandeEmpruntStatut.ACCEPTE)) {
            mediathequeService.realiserEmprunt(empruntJSON, adherentFromDatabase, documentFromDatabase);
            return ResponseEntity.status(201).build();
        }
        else {
            return ResponseEntity.badRequest().body(statut);
        }
    }
}
