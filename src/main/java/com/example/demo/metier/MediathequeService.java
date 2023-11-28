package com.example.demo.metier;

import com.example.demo.dao.entity.Adherent;
import com.example.demo.dao.entity.Document;
import com.example.demo.dao.entity.Emprunt;
import com.example.demo.dao.repository.AdherentRepository;
import com.example.demo.dao.repository.DocumentRepository;
import com.example.demo.dao.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MediathequeService {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    AdherentRepository adherentRepository;

    @Autowired
    EmpruntRepository empruntRepository;

    public List<Document> getDocuments(){
        return documentRepository.findAll();
    }
    public void addDocument(Document document){
        documentRepository.save(document);
    }

    public List<Adherent> getAdherents(){
        return adherentRepository.findAll();
    }
    public void addAdherent(Adherent adherent){
        adherentRepository.save(adherent);
    }

    public List<Emprunt> getEmprunts(){
        return empruntRepository.findAll();
    }

    public boolean realiserEmprunt(Emprunt empruntJSON, Adherent adherentFromDatabase, Document documentFromDatabase){
        DemandeEmpruntStatut statut = Mediatheque.canEmprunter(adherentFromDatabase, documentFromDatabase);
        if(statut.equals(DemandeEmpruntStatut.ACCEPTE)){
            Emprunt newEmprunt = Mediatheque
                    .realiseEmprunt(adherentFromDatabase, documentFromDatabase);

            empruntRepository.save(newEmprunt);
            adherentRepository.save(adherentFromDatabase);
            documentRepository.save(documentFromDatabase);

            return true;
        }
        else {
            return false;
        }
    }

    public Optional<Document> getDocumentById(Integer id) {
        return documentRepository.findById(id);
    }

    public Optional<Adherent> getAdherentById(Integer id) {
        return adherentRepository.findById(id);
    }
}
