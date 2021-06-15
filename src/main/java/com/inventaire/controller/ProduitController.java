package com.inventaire.controller;



import com.inventaire.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.List;


@Controller
public class ProduitController {

    @Autowired
    ProduitService produitService;

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
    static{
        trierPar = new ArrayList<>();
        trierPar.add("prix");
        trierPar.add("quantite");
        trierPar.add("date_cree");
    }

    @GetMapping("/produit_interface_employee")
    public String getProduitInterfaceEmployee(Model model){
        model.addAttribute("chercherPar",chercherPar);
        model.addAttribute("trierPar",trierPar);
        model.addAttribute("produits",produitService.findAllProduit());
        return "produit_interface_employee";
    }

    @GetMapping("/deletePoduit/{id_produit}")
    public void deleteProduit(@PathVariable int id_produit){
        produitService.deleteProduit(id_produit);
    }
}
