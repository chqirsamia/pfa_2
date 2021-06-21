package com.inventaire.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

@GetMapping("commandes/addMyProduit/{pid}-{id}-{qty}")
public String findProduitById_produit(@PathVariable int pid,@PathVariable int id,@PathVariable int qty){
    int qte= prodcomService.addQuantite(pid, id, qty);
    return qte+"a été ajouté à votre panier";
}
@PostMapping("commandes/updateQuantity/{pid}-{id}-{qty}")
public String updateQuantity(@PathVariable int pid,@PathVariable int id,@PathVariable int qty){
    float subtotal= prodcomService.updateQuantity(pid, qty, id);
    return String.valueOf(subtotal);
}
@PostMapping("commandes/delete/{pid}-{id}")
public String delete(@PathVariable int pid,@PathVariable int id){
    prodcomService.delete(pid, id);
    return "le produit a été supprimé";
}
}
