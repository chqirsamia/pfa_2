package com.inventaire.dao;

import com.inventaire.model.ProduitsNonCommandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitsNonCommandesDAO extends JpaRepository<ProduitsNonCommandes,Integer> {
    @Override
    List<ProduitsNonCommandes> findAll();

    @Query("select pnc from ProduitsNonCommandes pnc where pnc.id_produit=?1")
    ProduitsNonCommandes findProduitsNonCommandesById_produit(int id_produit);
}
