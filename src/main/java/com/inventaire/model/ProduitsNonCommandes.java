package com.inventaire.model;

import javax.persistence.*;

@Entity
@Table
public class ProduitsNonCommandes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_produit;

    public ProduitsNonCommandes(int id, int id_produit) {
        this.id = id;
        this.id_produit = id_produit;
    }

    public ProduitsNonCommandes() {
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
}
