package com.inventaire.model;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.inventaire.model.Commande;
import org.hibernate.annotations.ColumnDefault;


	@Entity
	@Table(name="panier")
	public class Panier {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@ManyToOne()
	    @JoinColumn(name = "id_produit")
	    private Produit produit;
		@ManyToOne()
		@JoinColumn(name = "id_demande")
	    private Commande commande;
		@Column(nullable=false,length=50)
		@ColumnDefault("0")
		private int quantite;
	@Column(nullable=true,length=50)
		
		private float prix;
	@Column(nullable=true,length=50)

	private float total;
		
		
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
		
		public float getPrix() {
			return prix;
		}
		public void setPrix(float prix) {
			this.prix=prix;
		}
		@Transient
		public float getTotal() {
			return this.produit.getPrix_unitaire()*quantite;
		}
		public void setTotal(float d) {
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
	 
	    public void setProduit(Produit produit) {
	        this.produit = produit;
	    }

	}



	
	

	


