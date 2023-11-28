package com.example.demo.metier;

import com.example.demo.dao.entity.Adherent;
import com.example.demo.dao.entity.Document;
import com.example.demo.dao.entity.Emprunt;

import java.time.LocalDate;

public class Mediatheque {


    public static DemandeEmpruntStatut canEmprunter(Adherent adherent, Document document){
        /*
        return !document.isEmprunte()
                  && adherent.getFinAdhesion().isAfter(LocalDate.now())
                        && adherent.getEmprunts().size() < 3;
         */
           if(document.isEmprunte())
               return DemandeEmpruntStatut.REFUSE_DOCUMENT_NON_DISPONIBLE;
           if(adherent.getFinAdhesion().isBefore(LocalDate.now()))
               return DemandeEmpruntStatut.REFUSE_ADHESION_PERIMEE;
           if(adherent.getEmprunts().size() == 3)
               return DemandeEmpruntStatut.REFUSE_QUOTA_ATTEINT;

           return DemandeEmpruntStatut.ACCEPTE;
    }

    public static Emprunt realiseEmprunt(Adherent adherent, Document document){
        Emprunt emprunt = new Emprunt();
        emprunt.setDocument(document);
        emprunt.setAdherent(adherent);

        document.setEmprunte(true);

        adherent.addEmprunt(emprunt);

        return emprunt;
    }
}
