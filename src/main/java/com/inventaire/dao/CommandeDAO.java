package com.inventaire.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventaire.User;
import com.inventaire.model.Commande;
import com.inventaire.model.Produit;
@Repository
public interface CommandeDAO extends JpaRepository<Commande,Integer> {
	 @Query("select p from Commande p where p.email=?1")
	    List<Commande> findByUser(String email);
	 @Query("select p from Commande p where p.id_employeur=?1")
	    List<Commande> findByEmployeur(Long id);
	 @Query("select p from Commande p where p.etat='E'")
	    List<Commande> findCommandeExterne();
	 @Query("select p from Commande p where p.id=?1")
	    Commande findById(int id);
}
