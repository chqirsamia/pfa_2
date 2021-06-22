package com.inventaire.model;

import javax.persistence.*;

@Entity
@Table
public class ProduitsNonCommandes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_produit;
    private Long id_user;

    public ProduitsNonCommandes(int id, int id_produit,Long id_user) {
        this.id = id;
        this.id_produit = id_produit;
        this.id_user = id_user;
    }

    public ProduitsNonCommandes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id) {
        this.id_user = id;
    }

    
    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }
}
