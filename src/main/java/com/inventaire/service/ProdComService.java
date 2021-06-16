package com.inventaire.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventaire.dao.CommandeDAO;
import com.inventaire.dao.ProduitDAO;
import com.inventaire.dao.ProdComDAO;
import com.inventaire.model.Commande;
import com.inventaire.model.ProdCom;

@Service
public class ProdComService {
	@Autowired
	
    ProdComDAO ProdComDAO;
@Autowired
	
    CommandeDAO commandeDAO;
@Autowired

ProduitDAO ProduitDAO;
	 public  List<ProdCom> findByCommande(int id){
	        return ProdComDAO.findByCommande(id);
	    }
	public int addProdCom(int id_produit, int idcom) {
		ProdCom prodcom=new ProdCom();
		prodcom.setCommande(commandeDAO.findById(idcom));
		prodcom.setProduit(ProduitDAO.findProduitById_produit(id_produit));
		prodcom.setPrix(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire());
		prodcom.setQuantite(1);
prodcom.setTotal(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire());
		ProdComDAO.save(prodcom);
		return prodcom.getId();
	}
	public int addQuantite(int id_produit, int idcom,int quantity) {
		int addedqty=quantity;
		ProdCom prodcom=ProdComDAO.findByCommandeandProduct(idcom, id_produit);
		if(prodcom !=null)
		{
			addedqty=prodcom.getQuantite()+quantity;
			prodcom.setQuantite(addedqty);
		}
		else {
			 prodcom=new ProdCom();
			prodcom.setCommande(commandeDAO.findById(idcom));
			prodcom.setProduit(ProduitDAO.findProduitById_produit(id_produit));
			prodcom.setPrix(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire());
			prodcom.setQuantite(quantity);
	prodcom.setTotal(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire()*quantity);
			
			
		}
		ProdComDAO.save(prodcom);
		return addedqty;
	}
	
}
