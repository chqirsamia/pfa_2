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

    public List<ProduitsCommandes> findAllProduitCommandes(Long id_user){
        return produitsCommandesDAO.findProduit(id_user);
    }

    public ProduitsCommandes addProduitsCommandes(int id_produit,int Quantite,Long id_user){
        ProduitsCommandes produitsCommandes = new ProduitsCommandes();
        produitsCommandes.setId_produit(id_produit);
        produitsCommandes.setId_user(id_user);
        produitsCommandes.setQuantite_commande(Quantite);
        produitsCommandesDAO.save(produitsCommandes);
        produitsNonCommandesService.deleteProduitsNonCommandes(id_produit,id_user);
        return produitsCommandes;
    }
    public List<ProduitsCommandes> deleteProduitsCommandes(int id_produit,Long id_user){
       
        produitsCommandesDAO.delete(produitsCommandesDAO.findProduitsCommandesById_produit_Byuser(id_produit,id_user));
        produitsNonCommandesService.addProduitsNonCommandes(id_produit,id_user);
        return produitsCommandesDAO.findProduit(id_user);
    }

    public List<ProduitsCommandes> deleteAllProduitsCommandes(Long id_user){
        produitsCommandesDAO.deleteByuser(id_user);
        produitsNonCommandesService.initProduitsNonCommandes(id_user);
        return produitsCommandesDAO.findAll();
    }

}
