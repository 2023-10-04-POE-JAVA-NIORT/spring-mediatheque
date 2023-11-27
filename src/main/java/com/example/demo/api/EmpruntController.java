package com.example.demo.api;

import com.example.demo.dao.entity.Document;
import com.example.demo.dao.entity.Emprunt;
import com.example.demo.metier.MediathequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addEmprunt(@RequestBody Emprunt emprunt){
        if(mediathequeService.realiserEmprunt(emprunt)){
            return ResponseEntity.status(201).build();
        }
        else
            return ResponseEntity.badRequest().body("Emprunt REFUSE");
    }
}
