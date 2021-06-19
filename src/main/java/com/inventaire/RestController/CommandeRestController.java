package com.inventaire.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inventaire.dao.ProduitDAO;
import com.inventaire.model.Produit;
import com.inventaire.service.ProduitService;
@RestController
public class CommandeRestController {
	 @Autowired
	    ProduitService produitService;

	    @Autowired
	    ProduitDAO produitDAO;
	@GetMapping("/commandes/findProduitById_produit/{id_produit}")
    public Produit findProduitById_produit(@PathVariable int id_produit){
        return produitDAO.findProduitById_produit(id_produit);
    }

    @GetMapping("/commandes/findProduitByNom_produit/{nom_produit}")
    public List<Produit> findProduitByNom_produit(@PathVariable String nom_produit){
        return produitService.findProduitByNom_produit(nom_produit);
    }

    @GetMapping("/commandes/findProduitByTitre/{titre}")
    public List<Produit> findProduitByTitre(String titre){
        return produitService.findProduitByTitre(titre);
    }

    @GetMapping("/commandes/findProduitByDescription/{description}")
    public List<Produit> findProduitByDescription(@PathVariable String description){
        return produitService.findProduitByDescription(description);
    }

    @GetMapping("/commandes/findProduitByMot_cle/{mot_cle}")
    public List<Produit> findProduitByMot_cle(@PathVariable String mot_cle){
        return produitService.findProduitByMot_cle(mot_cle);
    }

    @GetMapping("/commandes/findProduitsByCategorie/{categorie}")
    public List<Produit> findProduitsByCategorie(@PathVariable String categorie){
        return produitService.findProduitsByCategorie(categorie);
    }

    @GetMapping("/commandes/findProduitByEmplacement/{nom_emplacement}")
    public List<Produit> findProduitByEmplacement(@PathVariable String nom_emplacement){
        return produitService.findProduitByEmplacement(nom_emplacement);
    }

    @GetMapping("/commandes/findProduitByEmployee/{nom_employee}")
    public List<Produit> findProduitByEmployee(@PathVariable String nom_employee){
        return produitService.findProduitByEmployee(nom_employee);
    }

    @GetMapping("/commandes/findProduitByAnnee_cree/{annee}")
    public List<Produit> findProduitByAnnee_cree(@PathVariable String  annee){
        return produitService.findProduitByAnnee_cree(annee);
    }

    @GetMapping("/commandes/findProduitByMois_cree/{mois}")
    public List<Produit> findProduitByMois_cree(@PathVariable String mois){
        return produitService.findProduitByMois_cree(mois);
    }

    @GetMapping("/commandes/TrierParPrix")
    public List<Produit> TrierParPrix(){
        return produitService.TrierParPrix();
    }

    @GetMapping("/commandes/TrierParQuntite")
    public List<Produit> TrierParQuntite(){
        return produitService.TrierParQuntite();
    }

    @GetMapping("/commandes/TrierParDate_cree")
    public List<Produit> TrierParDate_cree(){
        return produitService.TrierParDate_cree();
    }
    @GetMapping("/commandes/findAllProduit")
    public List<Produit> findAllProduit(){
        return produitService.findAllProduit();
    }
}
