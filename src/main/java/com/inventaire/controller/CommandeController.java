package com.inventaire.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventaire.dao.ProduitDAO;
import com.inventaire.model.Commande;
import com.inventaire.model.ProdCom;
import com.inventaire.model.Produit;
import com.inventaire.service.CommandeService;
import com.inventaire.service.ProdComService;
import com.inventaire.service.ProduitService;

@Controller
public class CommandeController {
	 @Autowired
	    ProduitService produitService;
	@Autowired
    CommandeService commandeService;
	  @Autowired
	    ProduitDAO produitDAO;
	@GetMapping("/employeur/commandes")
	public String viewcommandes(Model model){
		List<Commande> list=commandeService.findCommandeExterne();
		model.addAttribute("list",list);
		return "commande";
	} 
	@PostMapping("/commandes/findAllProduits")
	public String insertNewCommande(@Valid Commande Commande, BindingResult result,Model model)
	{int id=commandeService.addNewCommande(Commande);
	
	model.addAttribute("id",id);
	return "redirect:/commandes/findProduit/"+id;}
	@GetMapping("/commandes/findProduit/{id}")
	public String afficher_produit(Model model,@PathVariable("id") int idcom)
	{
	  model.addAttribute("chercherPar",chercherPar);
	  model.addAttribute("id",idcom);
      model.addAttribute("trierPar",trierPar);
      model.addAttribute("produits",produitService.findAllProduit());
	return  "product";}
	
	@GetMapping("/commandes/newCommande")
	public String newCommande(Model model) {
		model.addAttribute("commande",new Commande());
		
		return "addCommande";
	}
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

   
	
	    
	    

}
