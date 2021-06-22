package com.inventaire.controller;


import com.inventaire.dao.CategorieDAO;
import com.inventaire.dao.EmplacementDAO;
import com.inventaire.model.Produit;
import com.inventaire.service.ProduitService;
import com.inventaire.service.ProduitsNonCommandesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    ProduitService produiService;

    @Autowired
    CategorieDAO categorieDAO;

    @Autowired
    EmplacementDAO emplacementDAO;

    @Autowired
    ProduitsNonCommandesService produitsNonCommandesService;

    static List<String> chercherPar;

    static {
        chercherPar = new ArrayList<>();
        chercherPar.add("All");
        /*chercherPar.add("Nom Produit");
        chercherPar.add("Titre");
        chercherPar.add("Description");*/
        chercherPar.add("Categorie");
        chercherPar.add("Emplacement");
        chercherPar.add("Employee");
        chercherPar.add("Année de creation");
        chercherPar.add("mois de creation");
    }

    static List<String> trierPar;

    static {
        trierPar = new ArrayList<>();
        trierPar.add("prix");
        trierPar.add("quantite");
        trierPar.add("date_cree");
    }


    @GetMapping("/produit_interface_client")
    public String getProduitInterfaceClient(Model model) {
        Produit produit = new Produit();
        model.addAttribute("produit", produit);
        model.addAttribute("chercherPar", chercherPar);
        model.addAttribute("trierPar", trierPar);
        model.addAttribute("produits", produiService.findAllProduit());
        model.addAttribute("categories", categorieDAO.findAll());
        model.addAttribute("emplacements", emplacementDAO.findAll());
        //produitsNonCommandesService.initProduitsNonCommandes();
        return "produit_interface_client";
    }
    @GetMapping("/produit_interface_panier/{id}")
    public String getProduitInterfacePanier(Model model,@PathVariable("id") Long id) {
    	model.addAttribute("id",id);
        return "produit_interface_panier";
    }



}
