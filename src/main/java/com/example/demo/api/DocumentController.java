package com.example.demo.api;

import com.example.demo.dao.entity.Document;
import com.example.demo.metier.MediathequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public void addDocument(@RequestBody Document document){
        mediathequeService.addDocument(document);
    }
}
