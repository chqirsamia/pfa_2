package com.inventaire.service;

import com.inventaire.dao.ProduitDAO;
import com.inventaire.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
	
    ProduitDAO produitDAO;

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
    
    public  Produit findProduitById(int id){
        return produitDAO.findProduitById_produit(id);
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

    public String deleteProduit(int id_produit){
        produitDAO.deleteById(id_produit);
        return "Produit "+produitDAO.findProduitById_produit(id_produit).getNom_produit()+ " a été supprimé avec succes";
    }

    public String deleteAll(){
        produitDAO.deleteAll();
        return "Touts les produits ont été supprimé avec succes!";
    }

	public void updateS(Produit produit,int qte) {
		int quantite=produit.getQuantite();
		if(quantite-qte>0)
		produit.setQuantite(quantite-qte);
		else
			produit.setQuantite(0);	
	 produitDAO.save(produit);
		
	}

	
}
