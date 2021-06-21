package com.inventaire.service;

import com.inventaire.dao.ProduitsCommandesDAO;
import com.inventaire.model.ProduitsCommandes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitsCommandesService {

    @Autowired
    ProduitsCommandesDAO produitsCommandesDAO;

    @Autowired
    ProduitsNonCommandesService produitsNonCommandesService;

    public List<ProduitsCommandes> findAllProduitCommandes(){
        return produitsCommandesDAO.findAll();
    }

    public ProduitsCommandes addProduitsCommandes(int id_produit,int Quantite){
        ProduitsCommandes produitsCommandes = new ProduitsCommandes();
        produitsCommandes.setId_produit(id_produit);
        produitsCommandes.setId_user(4);
        produitsCommandes.setQuantite_commande(Quantite);
        produitsCommandesDAO.save(produitsCommandes);
        produitsNonCommandesService.deleteProduitsNonCommandes(id_produit);
        return produitsCommandes;
    }
    public List<ProduitsCommandes> deleteProduitsCommandes(int id_produit){
        /*List<ProduitsCommandes> pcs = produitsCommandesDAO.findAll();
        for(int i=0;i<pcs.size();i++){
            if(id_produit == pcs.get(i).getId_produit()){
                produitsCommandesDAO.delete(pcs.get(i));
            }
        }*/
        produitsCommandesDAO.delete(produitsCommandesDAO.findProduitsCommandesById_produit(id_produit));
        produitsNonCommandesService.addProduitsNonCommandes(id_produit);
        return produitsCommandesDAO.findAll();
    }

    public List<ProduitsCommandes> deleteAllProduitsCommandes(){
        produitsCommandesDAO.deleteAll();
        produitsNonCommandesService.initProduitsNonCommandes();
        return produitsCommandesDAO.findAll();
    }

}
