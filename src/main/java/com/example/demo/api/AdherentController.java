package com.example.demo.api;

import com.example.demo.dao.entity.Adherent;
import com.example.demo.dao.entity.Document;
import com.example.demo.metier.MediathequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdherentController {

    @Autowired
    MediathequeService mediathequeService;

    @GetMapping("adherents")
    public List<Adherent> getAll(){
        return mediathequeService.getAdherents();
    }

    @PostMapping("adherents")
    public void addAdherent(@RequestBody Adherent adherent){
        mediathequeService.addAdherent(adherent);
    }
}
