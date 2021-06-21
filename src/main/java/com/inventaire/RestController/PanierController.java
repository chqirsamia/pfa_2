package com.inventaire.RestController;

import com.inventaire.model.Produit;
import com.inventaire.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PanierController {

    @Autowired
    ProduitService produitService;

    List<Produit> produitsCommandes = new ArrayList<>();
    List<Produit> produitsNonCommandes = new ArrayList<>();

    @GetMapping("/addProduitToPanier/{id_produit}")
    public void addProduitToPanier(@PathVariable int id_produit){
        produitsCommandes.add(produitService.findProduitById_produit(id_produit));
        System.out.println(id_produit);

    }


    @GetMapping("/allProduitsCommandes")
    public List<Produit> allProduitsCommandes(){
        return produitsCommandes;
    }

    @GetMapping("/allProduitsNonCommandes")
    public List<Produit> AllProduitNonCommandes(){
        int cle=0;
        int id_produitNonCommande=0;
        List<Produit> allProduits =produitService.findAllProduit();
        for(int i=0;i<allProduits.size();i++){
            for(int j=0;j<produitsCommandes.size();j++){
                if(allProduits.get(i).getId_produit()==produitsCommandes.get(j).getId_produit()) {
                    cle=1;
                }
            }
            if (cle == 0) {
                id_produitNonCommande = allProduits.get(i).getId_produit();
                produitsNonCommandes.add(produitService.findProduitById_produit(id_produitNonCommande));
            }
        }

        return produitsNonCommandes;
    }

}
