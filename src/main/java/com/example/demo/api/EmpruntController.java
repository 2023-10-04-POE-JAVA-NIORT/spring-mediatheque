package com.example.demo.api;

import com.example.demo.dao.entity.Document;
import com.example.demo.dao.entity.Emprunt;
import com.example.demo.metier.MediathequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpruntController {

    @Autowired
    MediathequeService mediathequeService;

    @GetMapping("emprunts")
    public List<Emprunt> getAll(){
        return mediathequeService.getEmprunts();
    }

    @PostMapping("emprunts")
    public void addEmprunt(@RequestBody Emprunt emprunt){
        mediathequeService.realiserEmprunt(emprunt);
    }
}
