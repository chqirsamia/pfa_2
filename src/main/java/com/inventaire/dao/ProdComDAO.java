package com.inventaire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.inventaire.User;
import com.inventaire.model.Commande;
import com.inventaire.model.ProdCom;
import com.inventaire.model.Produit;

@Repository
public interface ProdComDAO extends JpaRepository<ProdCom,Integer> {
	 @Query("select p from ProdCom p where p.commande.id=?1")
	    List<ProdCom> findByCommande(int id);
	
	 @Query("select p from ProdCom p where p.commande.id=?1 and p.produit.id_produit=?2")
	    ProdCom findByCommandeandProduct(int idcom,int idprod);
	 @Query("update  ProdCom p set p.quantite=?1 where p.commande.id=?3 and p.produit.id_produit=?2")
@Modifying
	 public void updateQuantity(int qty,int pid,int cid);
	 @Query("delete from  ProdCom p  where p.commande.id=?2 and p.produit.id_produit=?1")
	 @Modifying
	 public void delete(int pid,int cid);
	

	 
}