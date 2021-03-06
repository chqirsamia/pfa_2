package com.inventaire.RestController;

import com.inventaire.model.Produit;
import com.inventaire.model.ProduitsCommandes;
import com.inventaire.model.ProduitsNonCommandes;
import com.inventaire.service.ProduitService;
import com.inventaire.service.ProduitsNonCommandesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProduitsNonCommandesRestController {
    @Autowired
    ProduitsNonCommandesService produitsNonCommandesService;

    @Autowired
    ProduitService produitService;

    @GetMapping("/findAllProduitNC/{id_user}")
    public List<Produit> findAllProduitNC(@PathVariable("id_user") Long id_user){
        List<Produit> ps = new ArrayList<>();
        List<ProduitsNonCommandes> pncs= produitsNonCommandesService.findAllProduitsNonCommandesByid(id_user);
        for (int i=0;i<pncs.size();i++){
            ps.add(produitService.findProduitById_produit(pncs.get(i).getId_produit()));
        }
        return  ps;
    }

    @GetMapping("/findAllProduitsNonCommandes")
    public List<ProduitsNonCommandes> findAllProduitsNonCommandes(){
        return produitsNonCommandesService.findAllProduitsNonCommandes();
    }
}
