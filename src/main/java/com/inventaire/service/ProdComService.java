package com.inventaire.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventaire.dao.CommandeDAO;
import com.inventaire.dao.ProduitDAO;
import com.inventaire.dao.ProdComDAO;
import com.inventaire.dao.PanierDAO;

import com.inventaire.model.Commande;
import com.inventaire.model.Panier;
import com.inventaire.model.ProdCom;
import com.inventaire.model.Produit;

@Service
@Transactional
public class ProdComService {
	@Autowired
	
    ProdComDAO ProdComDAO;
@Autowired
	
    CommandeDAO commandeDAO;
@Autowired

ProduitDAO ProduitDAO;
@Autowired

PanierDAO PanierDAO;
	 public  List<ProdCom> findByCommande(int id){
	        return ProdComDAO.findByCommande(id);
	    }
	 public  List<Panier> findpanierByCommande(int id){
	        return PanierDAO.findByCommande(id);
	    }
	public int addProdCom(int id_produit, int idcom) {
		/*ProdCom prodcom=new ProdCom();
		prodcom.setCommande(commandeDAO.findById(idcom));
		prodcom.setProduit(ProduitDAO.findProduitById_produit(id_produit));
		prodcom.setPrix(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire());
		prodcom.setQuantite(1);
prodcom.setTotal(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire());
		ProdComDAO.save(prodcom);*/
		ProdCom prodcom=ProdComDAO.findByCommandeandProduct(idcom, id_produit);
		Panier panier=PanierDAO.findByCommandeandProduct(idcom, id_produit);

		if(prodcom !=null)
		{
			int addedqty=prodcom.getQuantite()+1;
			prodcom.setQuantite(addedqty);
			prodcom.setTotal(addedqty * prodcom.getPrix());
		
			panier.setQuantite(addedqty);
			panier.setTotal(addedqty * prodcom.getPrix());
		}
		else {
			 prodcom=new ProdCom();
			prodcom.setCommande(commandeDAO.findById(idcom));
			prodcom.setProduit(ProduitDAO.findProduitById_produit(id_produit));
			prodcom.setPrix(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire());
			prodcom.setQuantite(1);
			panier=new Panier();
			panier.setCommande(commandeDAO.findById(idcom));
			panier.setProduit(ProduitDAO.findProduitById_produit(id_produit));
			panier.setPrix(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire());
			panier.setQuantite(1);
		
			
		}
		ProdComDAO.save(prodcom);
		PanierDAO.save(panier);
		return prodcom.getId();
	}
	public int addQuantite(int id_produit, int idcom,int quantity) {
		int addedqty=quantity;
		ProdCom prodcom=ProdComDAO.findByCommandeandProduct(idcom, id_produit);
		Panier panier=PanierDAO.findByCommandeandProduct(idcom, id_produit);
		if(prodcom !=null)
		{
			addedqty=prodcom.getQuantite()+quantity;
			prodcom.setQuantite(addedqty);
			panier.setQuantite(addedqty);
		}
		else {
			 prodcom=new ProdCom();
			prodcom.setCommande(commandeDAO.findById(idcom));
			prodcom.setProduit(ProduitDAO.findProduitById_produit(id_produit));
			prodcom.setPrix(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire());
			prodcom.setQuantite(quantity);
	prodcom.setTotal(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire()*quantity);
			
	panier=new Panier();
	panier.setCommande(commandeDAO.findById(idcom));
	panier.setProduit(ProduitDAO.findProduitById_produit(id_produit));
	panier.setPrix(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire());
	panier.setQuantite(quantity);
	panier.setTotal(ProduitDAO.findProduitById_produit(id_produit).getPrix_unitaire()*quantity);
		
			
		}
		ProdComDAO.save(prodcom);
		PanierDAO.save(panier);
		return addedqty;
	}
	public float  updateQuantity(int pid,int qty,int cid) {
		
		ProdComDAO.updateQuantity(qty, pid, cid);
		PanierDAO.updateQuantity(qty, pid, cid);

		Produit product=ProduitDAO.findProduitById_produit(pid);
		System.out.print("voila:"+pid+qty+cid);
		float subtotal=product.getPrix_unitaire()*qty;
		return subtotal;
	}
public void delete(int pid,int cid) {
		
		ProdComDAO.delete( pid, cid);
		PanierDAO.delete( pid, cid);
		
	
	}
public void deleteCommande(int id) {
	PanierDAO.deletepanier(id);
	
}
	
}
