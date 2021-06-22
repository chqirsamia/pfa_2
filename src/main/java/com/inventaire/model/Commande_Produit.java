package com.inventaire.model;

import javax.persistence.*;

@Entity
@Table
public class Commande_Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_commande;
    private int id_produit;
    private int Quantite_commande;

    public Commande_Produit(int id, int id_commande, int id_produit, int quantite_commande) {
        this.id = id;
        this.id_commande = id_commande;
        this.id_produit = id_produit;
        Quantite_commande = quantite_commande;
    }

    public Commande_Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getQuantite_commande() {
        return Quantite_commande;
    }

    public void setQuantite_commande(int quantite_commande) {
        Quantite_commande = quantite_commande;
    }
}
