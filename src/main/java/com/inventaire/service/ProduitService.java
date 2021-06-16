package com.inventaire.service;

import com.inventaire.dao.CategorieDAO;
import com.inventaire.dao.EmplacementDAO;
import com.inventaire.dao.ProduitDAO;
import com.inventaire.model.Categorie;
import com.inventaire.model.Emplacement;
import com.inventaire.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
    ProduitDAO produitDAO;

    @Autowired
    CategorieDAO categorieDAO;

    @Autowired
    EmplacementDAO emplacementDAO;

    public List<Produit> findAllProduit(){
        return produitDAO.findAll();
    }

    /* Cherecher Produit par : */

    public List<Produit> findProduitByNom_produit(String nom_produit){
        return produitDAO.findProduitByNom_produit(nom_produit);
    }

    public List<Produit> findProduitByTitre(String titre){
        return produitDAO.findProduitByTitre(titre);
    }

    public List<Produit> findProduitByDescription(String description){
        return produitDAO.findProduitByDescription(description);
    }

    public List<Produit> findProduitByMot_cle(String mot_cle){
        return produitDAO.findProduitByMot_cle(mot_cle);
    }

    public List<Produit> findProduitsByCategorie(String categorie){
        return  produitDAO.findProduitsByCategorie(categorie);
    }

    public List<Produit> findProduitByEmplacement(String nom_emplacement){
        return produitDAO.findProduitByEmplacement(nom_emplacement);
    }

    public List<Produit> findProduitByEmployee(String nom_employee){
        return produitDAO.findProduitByEmployee(nom_employee);
    }

    public List<Produit> findProduitByAnnee_cree(String  annee){
        return produitDAO.findProduitByAnnee_cree(annee);
    }

    public List<Produit> findProduitByMois_cree(String mois){
        return produitDAO.findProduitByMois_cree(mois);
    }

    /* Trier par */
    public List<Produit> TrierParPrix(){
        return produitDAO.TrierParPrix();
    }

    public List<Produit> TrierParQuntite(){
        return produitDAO.TrierParQuntite();
    }

    public List<Produit> TrierParDate_cree(){
        return produitDAO.TrierParDate_cree();
    }

    /* Ajouter un produit */

    public Produit savePoduit(Produit produit){
        return produitDAO.save(produit);
    }

    /* Modifier un produit */

    public Produit updateProduit(int id_produit, Produit produit){
        produit.setId_produit(id_produit);
        return produitDAO.save(produit);
    }

    /* Delete Produit (s) */

    public List<Produit> deleteProduit(int id_produit){
        produitDAO.deleteById(id_produit);
        return produitDAO.findAll();
    }

    public String deleteAll(){
        produitDAO.deleteAll();
        return "Touts les produits ont été supprimé avec succes!";
    }
    public void registerProduit(MultipartFile file,
                                String nom_produit,
                                String titre,
                                String description,
                                int code,
                                String categorie,
                                String emplacement,
                                String employee,
                                float prix,
                                int quantite,
                                String etat_stock,
                                Date date_cree){

            Produit produit = new Produit();
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("not a a valid file");
            }
            try {
                produit.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Categorie categorie1 = categorieDAO.findCategoriebyNom_categorie(categorie);
            Emplacement emplacement1 = emplacementDAO.findEmplacementByNom_emplacement(emplacement);
            System.out.println("emplacement1.getId_emplacement() :"+emplacement1.getId_emplacement());
            produit.setNom_produit(nom_produit);
            produit.setTitre(titre);
            produit.setDescription(description);
            produit.setCode(code);
            produit.setId_emplacement(emplacement1.getId_emplacement());
            produit.setId_categorie(categorie1.getId_categorie());
            produit.setId_employee(1);
            produit.setPrix_unitaire(prix);
            produit.setQuantite(quantite);
            produit.setEtat_stock(etat_stock);
            produit.setDate_cree(date_cree);
            produitDAO.save(produit);

    }
}
