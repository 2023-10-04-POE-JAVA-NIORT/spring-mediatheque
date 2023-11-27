package com.example.demo.metier;

import com.example.demo.dao.entity.Adherent;
import com.example.demo.dao.entity.Document;
import com.example.demo.dao.entity.Emprunt;

import java.time.LocalDate;

public class Mediatheque {


    public static boolean canEmprunter(Adherent adherent, Document document){
        return !document.isEmprunte()
                && adherent.getFinAdhesion().isAfter(LocalDate.now())
                && adherent.getEmprunts().size() < 3;
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
