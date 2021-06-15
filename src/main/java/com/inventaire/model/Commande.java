package com.inventaire.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
@Entity
@Table(name="commandes")
public class Commande {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column(nullable=false,length=50)
		private String nom;
		@Column(nullable=true,length=50)
		private String prenom;
		@Column(nullable=false,length=100)
		private String email;
		@Column(nullable=false,length=10)
		private String sexe;
		@Column(nullable=false,length=10)
		private String tel;
		@Column(nullable=false,length=100)
		private Date date_commande;
		@Column(nullable=false,length=100)
		private float total;
		@Column(nullable=false,length=100)
		private String etat;
		@Column(nullable=false,length=100)
		private Long id_employeur ;//employeur qui a entre la commande
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSexe() {
			return sexe;
		}
		public void setSexe(String sexe) {
			this.sexe = sexe;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public Date getDate() {
			return date_commande;
		}
		public void setDate(java.util.Date date) {
			this.date_commande=date;
		}
		public float getTotal() {
			return total;
		}
		public void setTotal(float d) {
			this.total = d;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat=etat;
		}
}
		
