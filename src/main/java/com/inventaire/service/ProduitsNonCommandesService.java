package com.inventaire.service;

import com.inventaire.dao.ProduitsNonCommandesDAO;
import com.inventaire.model.Produit;
import com.inventaire.model.ProduitsCommandes;
import com.inventaire.model.ProduitsNonCommandes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitsNonCommandesService {

    @Autowired
    ProduitsNonCommandesDAO produitsNonCommandesDAO;

    @Autowired
    ProduitService produitService;

    public List<ProduitsNonCommandes> findAllProduitsNonCommandes(){
        return produitsNonCommandesDAO.findAll();
    }
    public void initProduitsNonCommandes(){
        produitsNonCommandesDAO.deleteAll();
        List<Produit> ps = produitService.findAllProduit();
        for(int i=0; i<ps.size();i++){
            ProduitsNonCommandes pnc = new ProduitsNonCommandes();
            pnc.setId_produit(ps.get(i).getId_produit());
            produitsNonCommandesDAO.save(pnc);
        }
    }

    public void addProduitsNonCommandes(int id_produit){
        ProduitsNonCommandes pnc = new ProduitsNonCommandes();
        pnc.setId_produit(id_produit);
        produitsNonCommandesDAO.save(pnc);
    }
    public void deleteProduitsNonCommandes(int id_produit){
        produitsNonCommandesDAO.delete(produitsNonCommandesDAO.findProduitsNonCommandesById_produit(id_produit));
    }

}
