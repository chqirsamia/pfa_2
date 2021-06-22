package com.inventaire.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_commande ;
    private float totale;
    private Date date_commande ;
    private Long id_user;

    public Command(int id_commande, float totale, Date date_commande, Long id_user) {
        this.id_commande = id_commande;
        this.totale = totale;
        this.date_commande = date_commande;
        this.id_user = id_user;
    }

    public Command() {
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public float getTotale() {
        return totale;
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user2) {
        this.id_user = id_user2;
    }
}
