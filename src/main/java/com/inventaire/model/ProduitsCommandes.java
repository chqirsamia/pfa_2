package com.inventaire.model;

import javax.persistence.*;

@Entity
@Table
public class ProduitsCommandes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_produit;
    private int Quantite_commande;
    private int id_user;

    public ProduitsCommandes(int id, int id_produit, int quantite_commande, int id_user) {
        this.id = id;
        this.id_produit = id_produit;
        Quantite_commande = quantite_commande;
        this.id_user = id_user;
    }

    public ProduitsCommandes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
