package com.inventaire.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inventaire.dao.ProdComDAO;
import com.inventaire.model.Produit;
import com.inventaire.service.ProdComService;

@RestController
public class ProdComRestController {

@Autowired
ProdComService prodcomService;

@Autowired
ProdComDAO prodComDAO;

@GetMapping("commandes/addMyProduit/{id_produit}-{idcom}-{qty}")
public String findProduitById_produit(@PathVariable int id_produit,@PathVariable int idcom,@PathVariable int qty){
    int qte= prodcomService.addQuantite(id_produit, idcom, qty);
    return qte+"a été ajouté à votre panier";
}

}
