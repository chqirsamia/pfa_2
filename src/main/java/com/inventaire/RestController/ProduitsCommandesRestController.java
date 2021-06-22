package com.inventaire.RestController;

import com.inventaire.model.Produit;
import com.inventaire.model.ProduitC;
import com.inventaire.model.ProduitsCommandes;
import com.inventaire.service.ProduitService;
import com.inventaire.service.ProduitsCommandesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProduitsCommandesRestController {
    @Autowired
    ProduitsCommandesService produitsCommandesService;
    @Autowired
    ProduitService produitService;

    /*@GetMapping("/findAllProduitC")
    public List<Produit> findAllProduitC(){
        List<Produit> ps = new ArrayList<>();
        List<ProduitsCommandes> pcs= produitsCommandesService.findAllProduitCommandes();
        for (int i=0;i<pcs.size();i++){
           ps.add(produitService.findProduitById_produit(pcs.get(i).getId_produit()));
        }
        return  ps;
    }*/

    @GetMapping("/findAllProduitC/{id_user}")
    public List<ProduitC> findAllProduitC(@PathVariable Long id_user){
        List<ProduitC> ps = new ArrayList<>();
        List<ProduitsCommandes> pcs= produitsCommandesService.findAllProduitCommandes(id_user);
        for (int i=0;i<pcs.size();i++){
            Produit p = produitService.findProduitById_produit(pcs.get(i).getId_produit());
            ProduitC pC = new ProduitC( p.getId_produit(),p.getNom_produit(),  p.getTitre(),
                     p.getDescription(), p.getImage(), p.getPrix_unitaire(), pcs.get(i).getQuantite_commande());

            ps.add(pC);
        }
        return  ps;
    }

    @GetMapping("/findAllProduitCommandes/{id}")
    public List<ProduitsCommandes> findAllProduitCommandes(@PathVariable Long id_user){
        return produitsCommandesService.findAllProduitCommandes(id_user);
    }

    @GetMapping("/addProduitsCommandes/{id_produit}/{Quantite}/{id_user}")
    public ProduitsCommandes addProduitsCommandes(@PathVariable int id_produit,@PathVariable int Quantite,@PathVariable Long id_user){
       return produitsCommandesService.addProduitsCommandes(id_produit,Quantite,id_user);
    }
    @GetMapping("/deleteProduitsCommandes/{id_produit}/{id_user}")
    public List<ProduitsCommandes> deleteProduitsCommandes(@PathVariable int id_produit,@PathVariable Long id_user){
       return produitsCommandesService.deleteProduitsCommandes(id_produit,id_user);
    }
    @GetMapping("/deleteAllProduitsCommandes/{id_user}")
    public List<ProduitsCommandes> deleteAllProduitsCommandes(@PathVariable Long id_user) {
       return produitsCommandesService.deleteAllProduitsCommandes(id_user);
    }

}
