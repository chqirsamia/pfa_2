package com.inventaire.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_categorie;
    private String nom_categorie;
    
    private String description;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    private Date date_cree;
    private Date date_modifier;
    private Date date_suppr;

    public Categorie(int id_categorie, String nom_categorie, String description, String image, Date date_cree, Date date_modifier, Date date_suppr) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
     
        this.description = description;
        this.image = image;
        this.date_cree = date_cree;
        this.date_modifier = date_modifier;
        this.date_suppr = date_suppr;
    }

    public Categorie() {
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate_cree() {
        return date_cree;
    }

    public void setDate_cree(Date date_cree) {
        this.date_cree = date_cree;
    }

    public Date getDate_modifier() {
        return date_modifier;
    }

    public void setDate_modifier(Date date_modifier) {
        this.date_modifier = date_modifier;
    }

    public Date getDate_suppr() {
        return date_suppr;
    }

    public void setDate_suppr(Date date_suppr) {
        this.date_suppr = date_suppr;
    }
}
