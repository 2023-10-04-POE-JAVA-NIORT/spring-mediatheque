package com.example.demo.api;

import com.example.demo.dao.entity.Document;
import com.example.demo.metier.MediathequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentController {

    @Autowired
    MediathequeService mediathequeService;

    @GetMapping("documents")
    public List<Document> getAll(){
        return mediathequeService.getDocuments();
    }

    @PostMapping("documents")
    @ResponseStatus( HttpStatus.CREATED )
    public void addDocument(@RequestBody Document document){
        mediathequeService.addDocument(document);
    }
}
