package com.inventaire.model;

import javax.persistence.*;
import java.sql.Date;

public class ProduitC {


    private int id_produitC;
    private String nom_produit;
    private String titre;
    private String description;
    private String image;
    private float prix_unitaire;
    private int quantiteC;

    public ProduitC(int id_produitC, String nom_produit, String titre, String description, String image, float prix_unitaire, int quantiteC) {
        this.id_produitC = id_produitC;
        this.nom_produit = nom_produit;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.prix_unitaire = prix_unitaire;
        this.quantiteC = quantiteC;
    }

    public ProduitC() {
    }

    public int getId_produitC() {
        return id_produitC;
    }

    public void setId_produitC(int id_produitC) {
        this.id_produitC = id_produitC;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getQuantiteC() {
        return quantiteC;
    }

    public void setQuantiteC(int quantiteC) {
        this.quantiteC = quantiteC;
    }
}
