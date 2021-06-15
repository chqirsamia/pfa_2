package com.inventaire.model;

import javax.persistence.*;

@Entity
@Table
public class Emplacement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_emplacement;
    private String nom_emplacement;

    public Emplacement(int id_emplacement, String nom_emplacement) {
        this.id_emplacement = id_emplacement;
        this.nom_emplacement = nom_emplacement;
    }

    public Emplacement() {
    }

    public int getId_emplacement() {
        return id_emplacement;
    }

    public void setId_emplacement(int id_emplacement) {
        this.id_emplacement = id_emplacement;
    }

    public String getNom_emplacement() {
        return nom_emplacement;
    }

    public void setNom_emplacement(String nom_emplacement) {
        this.nom_emplacement = nom_emplacement;
    }
}
