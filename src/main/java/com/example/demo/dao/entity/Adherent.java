package com.example.demo.dao.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "adherents")
public class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String prenom;
    private String nom;
    private String email;
    private LocalDate finAdhesion;

    public Adherent() {
        this.finAdhesion = LocalDate.now().plusYears(1);
    }

    public Adherent(String prenom, String nom) {
        this();
        this.prenom = prenom;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getFinAdhesion() {
        return finAdhesion;
    }

    public void setFinAdhesion(LocalDate finAdhesion) {
        this.finAdhesion = finAdhesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Adherent{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", finAdhesion=" + finAdhesion +
                '}';
    }
}
