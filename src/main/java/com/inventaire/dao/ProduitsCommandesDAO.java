package com.inventaire.dao;

import com.inventaire.model.ProduitsCommandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitsCommandesDAO extends JpaRepository<ProduitsCommandes,Integer> {
    @Override
    List<ProduitsCommandes> findAll();

    @Query("select pc from ProduitsCommandes pc where pc.id_produit=?1")
    ProduitsCommandes findProduitsCommandesById_produit(int id_produit);
}
