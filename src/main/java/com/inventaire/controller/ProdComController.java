package com.inventaire.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventaire.model.Commande;
import com.inventaire.model.Panier;
import com.inventaire.model.ProdCom;
import com.inventaire.model.Produit;
import com.inventaire.service.CommandeService;
import com.inventaire.service.ProdComService;
import com.inventaire.service.ProduitService;


@Controller
public class ProdComController {
	private final ProdComService  prodcomService ;
	private final CommandeService  comService ;
	private final ProduitService  prodService ;
	

	public ProdComController(ProdComService  prodcomService,CommandeService  comService,ProduitService  prodService) {
		this.prodcomService  =prodcomService;
		this.comService = comService;
		this.prodService = prodService;
	}
	
	@GetMapping("/commandes/produits/{idcom}")
	public String viewproductCommande(Model model,@PathVariable("idcom") int idcom){
		model.addAttribute("idcom",idcom);
		List<ProdCom> list=prodcomService.findByCommande(idcom);
		//List<Produit> listpro=new ArrayList<Produit>();
		/*for( ProdCom produit : list ) {
           Produit prod= ProduitService.findProduitById(produit.getId());
           listpro.add(prod);
        }*/
		Commande commande=comService.findbyId(idcom);
		model.addAttribute("total",commande.getTotal());
		model.addAttribute("list",list);
		return "product-list";
	} 

	@GetMapping("/commandes/addPoduit/{id_produit}-{idcom}")
    public void addProduitPanier(@PathVariable int id_produit,@PathVariable int idcom){
        prodcomService.addProdCom(id_produit,idcom);
    } 
	@GetMapping("/commandes/panier/{idcom}")
	public String viewpanier(Model model,@PathVariable("idcom") int idcom){
		model.addAttribute("id",idcom);
		List<Panier> list=prodcomService.findpanierByCommande(idcom);
		//List<Produit> listpro=new ArrayList<Produit>();
		/*for( ProdCom produit : list ) {
           Produit prod= ProduitService.findProduitById(produit.getId());
           listpro.add(prod);
        }*/
		Commande commande=comService.findbyId(idcom);
		model.addAttribute("total",commande.getTotal());
		model.addAttribute("list",list);
		return "panier";
	}  
	@GetMapping("/commandes/deletepanier/{idcom}")
	public String deletepanier(Model model,@PathVariable("idcom") int idcom){
		model.addAttribute("id",idcom);
		Commande commande=comService.findbyId(idcom);
		List<ProdCom> liste=prodcomService.findByCommande(idcom);
		float total=0;
		for( ProdCom produit : liste ) {
	           Produit prod= prodService.findProduitById(produit.getId());
	           total=total+produit.getTotal();
	           int qte=produit.getQuantite();
	           prodService.updateS(produit.getProduit() ,qte )    ;   
		}
		 comService.updateT(idcom,total,commande);
		
		 List<Commande> list=comService.findCommandeExterne();
			model.addAttribute("list",list);
		//prodcomService.deleteCommande(idcom);
	
		return "commande";
	}  
}
