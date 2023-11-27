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

    public boolean realiserEmprunt(Emprunt empruntDTO){
        Adherent adherent = empruntDTO.getAdherent();
        Document document = empruntDTO.getDocument();

        if(Mediatheque.canEmprunter(adherent, document)){
            Emprunt emprunt = Mediatheque
                    .realiseEmprunt(adherent, document);

            empruntRepository.save(emprunt);
            adherentRepository.save(adherent);
            documentRepository.save(document);

            return true;
        }
        else {
            return false;
        }
    }
}
