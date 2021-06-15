package com.inventaire.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_produit;
    private int id_categorie;
    private int id_emplacement;
    private int id_employee;
    private int code;
    private String nom_produit;
    private String titre;
    private String description;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    private float prix_unitaire;
    private int quantite;
    private String etat_stock;
    private Date date_cree;
    private Date date_modifier;
    private Date date_suppr;


    public Produit(int id_produit, int id_categorie, int id_emplacement, int id_employee, int code, String nom_produit, String titre, String description, String image, float prix_unitaire, int quantite, String etat_stock, Date date_cree, Date date_modifier, Date date_suppr) {
        this.id_produit = id_produit;
        this.id_categorie = id_categorie;
        this.id_emplacement = id_emplacement;
        this.id_employee = id_employee;
        this.code = code;
        this.nom_produit = nom_produit;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.prix_unitaire = prix_unitaire;
        this.quantite = quantite;
        this.etat_stock = etat_stock;
        this.date_cree = date_cree;
        this.date_modifier = date_modifier;
        this.date_suppr = date_suppr;
    }

    public Produit() {
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getId_emplacement() {
        return id_emplacement;
    }

    public void setId_emplacement(int id_emplacement) {
        this.id_emplacement = id_emplacement;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getEtat_stock() {
        return etat_stock;
    }

    public void setEtat_stock(String etat_stock) {
        this.etat_stock = etat_stock;
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
