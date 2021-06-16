package com.inventaire.dao;

import com.inventaire.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieDAO extends JpaRepository<Categorie, Integer> {


    @Override
    List<Categorie> findAll();

    @Query("select c from Categorie c where c.nom_categorie like ?1")
    Categorie findCategoriebyNom_categorie(String nom_categorie);

}
