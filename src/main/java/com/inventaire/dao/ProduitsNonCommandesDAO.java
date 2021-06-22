package com.inventaire.dao;

import com.inventaire.model.ProduitsNonCommandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitsNonCommandesDAO extends JpaRepository<ProduitsNonCommandes,Integer> {
    @Override
    List<ProduitsNonCommandes> findAll();

    @Query("select pnc from ProduitsNonCommandes pnc where pnc.id_produit=?1")
    ProduitsNonCommandes findProduitsNonCommandesById_produit(int id_produit);
    @Query("select pnc from ProduitsNonCommandes pnc where pnc.id_produit=?1 and id_user=?2")
    ProduitsNonCommandes findProduitsNonCommandesById_produit_Byuser(int id_produit,Long id);
   @Query("delete from ProduitsNonCommandes pc where pc.id_user=?1")
    @Modifying
	void deleteByuser(Long id_user);
    @Query("select pnc from ProduitsNonCommandes pnc where pnc.id_user=?1")
    List<ProduitsNonCommandes>  findProduitsNonCommandesByuser(Long id_user);
   

	
}
