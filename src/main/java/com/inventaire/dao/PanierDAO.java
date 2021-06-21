package com.inventaire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventaire.model.Panier;
import com.inventaire.model.ProdCom;

@Repository
public interface PanierDAO extends JpaRepository<Panier,Integer> {
	 @Query("select p from Panier p where p.commande.id=?1")
	    List<Panier> findByCommande(int id);
	
	 @Query("select p from  Panier  p where p.commande.id=?1 and p.produit.id_produit=?2")
	    Panier findByCommandeandProduct(int idcom,int idprod);
	 @Query("update   Panier  p set p.quantite=?1 where p.commande.id=?3 and p.produit.id_produit=?2")
@Modifying
	 public void updateQuantity(int qty,int pid,int cid);
	 @Query("delete from   Panier  p  where p.commande.id=?2 and p.produit.id_produit=?1")
	 @Modifying
	 public void delete(int pid,int cid);
	 @Query("delete from   Panier  p  where p.commande.id=?1 ")
	 @Modifying
	public void deletepanier(int id);
}
