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
    public void initProduitsNonCommandes(Long id_user){
        produitsNonCommandesDAO.deleteByuser(id_user);
        List<Produit> ps = produitService.findAllProduit();
        for(int i=0; i<ps.size();i++){
            ProduitsNonCommandes pnc = new ProduitsNonCommandes();
            pnc.setId_produit(ps.get(i).getId_produit());
            pnc.setId_user(id_user);
            produitsNonCommandesDAO.save(pnc);
        }
    }

    public void addProduitsNonCommandes(int id_produit, Long id_user){
        ProduitsNonCommandes pnc = new ProduitsNonCommandes();
        pnc.setId_produit(id_produit);
        pnc.setId_user(id_user);
        produitsNonCommandesDAO.save(pnc);
    }
    public void deleteProduitsNonCommandes(int id_produit,Long id_user){
        produitsNonCommandesDAO.delete(produitsNonCommandesDAO.findProduitsNonCommandesById_produit_Byuser(id_produit,id_user));
    }
	public List<ProduitsNonCommandes> findAllProduitsNonCommandesByid(Long id_user) {
		List<ProduitsNonCommandes> list= produitsNonCommandesDAO.findProduitsNonCommandesByuser(id_user);

		return list;
	}

}
