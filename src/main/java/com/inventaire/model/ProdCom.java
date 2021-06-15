package com.inventaire.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import javax.persistence.ForeignKey;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name="produits_commandes")
public class ProdCom {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit",referencedColumnName="id_produit",insertable=false,updatable=false
    , nullable = false)
    private Produit produit;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_demande",referencedColumnName="id",insertable=false,updatable=false
	, nullable = false)
    private Commande commande;
	@Column(nullable=false,length=50)
	@ColumnDefault("0")
	private int quantite;
@Column(nullable=true,length=50)
	
	private double prix;
@Column(nullable=true,length=50)

private double total;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int qte) {
		this.quantite=qte;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix=prix;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double d) {
		this.total = d;
	}
	public Commande getCommande() {
        return commande;
    }
 
    public void setCommande(Commande Commande) {
        this.commande=Commande;
    }
 
    public Produit getProduit() {
        return produit;
    }
 
    public void setProduct(Produit produit) {
        this.produit = produit;
    }

}
