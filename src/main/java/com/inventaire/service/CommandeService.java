package com.inventaire.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventaire.dao.CommandeDAO;
import com.inventaire.model.Commande;

@Service
public class CommandeService {
	@Autowired
	
    CommandeDAO CommandeDAO;

@Autowired

public CommandeService(CommandeDAO CommandeDAO) {
	this.CommandeDAO= CommandeDAO;
}
	 public List<Commande> findCommandeExterne(){
	        return CommandeDAO.findCommandeExterne();
	    }
	 public  Commande findbyId(int id){
	        return CommandeDAO.findById(id);
	    }
	 public int addNewCommande(Commande Commande) {
			Commande.setDate(new Date());
			Commande.setEtat("E");
			
		 CommandeDAO.save(Commande);
		 return Commande.getId();
		}
}
