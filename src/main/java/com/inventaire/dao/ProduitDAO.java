package com.inventaire.dao;


import com.inventaire.model.Produit;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ProduitDAO extends JpaRepository<Produit,Integer> {
    @Override
    List<Produit> findAll();

    @Query("select p from Produit p where  p.quantite>0")
    List<Produit> find();
    
    /* Cherecher Produit par : */

    @Query("select p from Produit p where p.id_produit =?1 and p.quantite>0")
    Produit findProduitById_produit(int id_produit);

    /* Par Code */
    @Query("select p from Produit p where p.code =?1 ")
    Produit findProduitByCode(int code);

    /* Nom Produit */
    @Query("select p from Produit p where p.nom_produit like %?1%")
    List<Produit> findProduitByNom_produit(String nom_produit);

    /* Titre */
    @Query("select p from Produit p where p.titre like %?1%")
    List<Produit> findProduitByTitre(String titre);

    /* Description */
    @Query("select p from Produit p where p.description like %?1%")
    List<Produit> findProduitByDescription(String description);

    /* Mot clé */
    @Query("select p from Produit p where p.nom_produit like %?1% or p.titre like %?1% or p.description like %?1%")
    List<Produit> findProduitByMot_cle(String mot_cle);

    /* Categorie */
    @Query("select p from Produit p where p.id_categorie in (select c.id_categorie from Categorie c where c.nom_categorie like %?1%)")
    List<Produit> findProduitsByCategorie(String categorie);

    /* Emplacement */
    @Query("select p from Produit p where p.id_emplacement in (select e.id_emplacement from Emplacement e where e.nom_emplacement like %?1%)")
    List<Produit> findProduitByEmplacement(String nom_emplacement);

    /* Employee */
    @Query("select p from Produit p where p.id_employee in (select e.id_employee from Employee e where e.nom_employee like %?1%)")
    List<Produit> findProduitByEmployee(String nom_employee);

    /* Année de creation */
    //@Query("select p from Produit p where DATE_FORMAT(p.date_cree, '%Y')= ?1")
    @Query("select p from Produit p where function('date_format', p.date_cree, '%Y')= ?1")
    List<Produit> findProduitByAnnee_cree(String  annee);

    /* mois de creation */
    @Query("select p from Produit p where function('date_format', p.date_cree, '%m')= ?1")
    List<Produit> findProduitByMois_cree(String mois);


    /*Trier par*/

    /* prix_unitaire */
    @Query("select p from Produit p order by p.prix_unitaire desc ")
    List<Produit> TrierParPrix();

    /* Top n prix_unitaire */
    /*@Query("select p from Produit p where function('LIMIT',?1) order by p.prix_unitaire desc ")
    Produit TrierParPrix(int n);*/

    /* quantite */
    @Query("select p from Produit p order by p.quantite desc ")
    List<Produit> TrierParQuntite();

    /* date_cree */
    @Query("select p from Produit p order by p.date_cree desc ")
    List<Produit> TrierParDate_cree();

	


}
