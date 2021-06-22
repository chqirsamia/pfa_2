package com.inventaire.dao;

import com.inventaire.model.Commande_Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Commande_ProduitDAO extends JpaRepository<Commande_Produit,Integer> {

    @Override
    List<Commande_Produit> findAll();
}
