package com.inventaire.dao;

import com.inventaire.model.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmplacementDAO extends JpaRepository<Emplacement, Integer> {

    @Override
    List<Emplacement> findAll();

    @Query("select e from Emplacement e where e.nom_emplacement like ?1")
    Emplacement findEmplacementByNom_emplacement(String nom_emplacement);

    @Query("select e from Emplacement e where e.id_emplacement =?1")
    Emplacement findEmplacementById_Emplacement(int id_emplacement);
}
