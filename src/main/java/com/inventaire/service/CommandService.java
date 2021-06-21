package com.inventaire.service;

import com.inventaire.dao.CommandDAO;
import com.inventaire.dao.Commande_ProduitDAO;
import com.inventaire.dao.SequenceDAO;
import com.inventaire.model.Command;
import com.inventaire.model.Commande_Produit;
import com.inventaire.model.ProduitsCommandes;
import com.inventaire.model.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommandService {

    @Autowired
    CommandDAO commandDAO;

    @Autowired
    ProduitsCommandesService produitsCommandesService;

    @Autowired
    ProduitService produitService;

    @Autowired
    SequenceService sequenceService;

    @Autowired
    Commande_ProduitDAO commande_produitDAO;


    public List<Command> findAllCommand(){
        return commandDAO.findAll();
    }
    public Command addCommande(){//int id_user
        Sequence s = new Sequence();
        sequenceService.addSequence(s);
        List<ProduitsCommandes> pc = produitsCommandesService.findAllProduitCommandes();
        Command command =new Command();
        command.setId_commande(sequenceService.findPlusGrand());
        command.setId_user(4);
        float totale =0;
        /* Calcule totale */
        for(int i=0; i<pc.size();i++){
            if(pc.get(i).getId_user()==command.getId_user()){
                totale+= pc.get(i).getQuantite_commande() * produitService.findProduitById_produit(pc.get(i).getId_produit()).getPrix_unitaire();
                Commande_Produit cp = new Commande_Produit();
                cp.setId_commande(command.getId_commande());
                cp.setId_produit(pc.get(i).getId_produit());
                cp.setQuantite_commande(pc.get(i).getQuantite_commande());
                commande_produitDAO.save(cp);
                produitService.findProduitById_produit(pc.get(i).getId_produit()).setQuantite(
                        produitService.findProduitById_produit(pc.get(i).getId_produit()).getQuantite() - pc.get(i).getQuantite_commande()
                );
                produitService.savePoduit(produitService.findProduitById_produit(pc.get(i).getId_produit()));

                produitsCommandesService.deleteProduitsCommandes(pc.get(i).getId_produit());

            }
        }
        command.setTotale(totale);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String datee = formatter.format(date);
        java.sql.Date sqld = java.sql.Date.valueOf(datee);
        command.setDate_commande(sqld);
        commandDAO.save(command);
        return command;
    }

}
