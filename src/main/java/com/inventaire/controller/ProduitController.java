package com.inventaire.controller;



import com.inventaire.dao.CategorieDAO;
import com.inventaire.dao.EmplacementDAO;
import com.inventaire.model.Categorie;
import com.inventaire.model.Produit;
import com.inventaire.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;


import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ProduitController {

    @Autowired
    ProduitService produiService;

    @Autowired
    CategorieDAO categorieDAO;

    @Autowired
    EmplacementDAO emplacementDAO;


    static List<String> chercherPar;

    static {
        chercherPar = new ArrayList<>();
        chercherPar.add("All");
        /*chercherPar.add("Nom Produit");
        chercherPar.add("Titre");
        chercherPar.add("Description");*/
        chercherPar.add("Categorie");
        chercherPar.add("Emplacement");
        chercherPar.add("Employee");
        chercherPar.add("Année de creation");
        chercherPar.add("mois de creation");
    }

    static List<String> trierPar;

    static {
        trierPar = new ArrayList<>();
        trierPar.add("prix");
        trierPar.add("quantite");
        trierPar.add("date_cree");
    }


    @GetMapping("/produit_interface_employee")
    public String getProduitInterfaceEmployee(Model model) {
        Produit produit = new Produit();
        model.addAttribute("produit", produit);
        model.addAttribute("chercherPar", chercherPar);
        model.addAttribute("trierPar", trierPar);
        model.addAttribute("produits", produiService.findAllProduit());
        model.addAttribute("categories", categorieDAO.findAll());
        model.addAttribute("emplacements", emplacementDAO.findAll());
        return "produit_interface_employee";
    }

    @PostMapping("/CreateProduit")
    public String saveProduit(@RequestParam("file") MultipartFile file,
                              @RequestParam("nom_produit") String nom_produit,
                              @RequestParam("titre") String titre,
                              @RequestParam("description") String description,
                              @RequestParam("code") int code,
                              @RequestParam("categorie") String categorie,
                              @RequestParam("emplacement") String emplacement,
                              @RequestParam("prix_unitaire") float prix,
                              @RequestParam("quantite") int quantite,
                              @RequestParam("etat_stock") String etat_stock,
                              @RequestParam("date_cree") String date_cree) throws ParseException {


        System.out.println("first date : " + date_cree);
        DateFormat formaDate = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = formaDate.parse(date_cree);
        System.out.println(" date after parser: " + date_cree);
        String date = formaDate.format(d);
        System.out.println(" date after format: " + date_cree);


        java.sql.Date sqld = java.sql.Date.valueOf(date);


        produiService.registerProduit(file, nom_produit, titre, description, code, categorie, emplacement,
                prix, quantite, etat_stock, sqld);

        return "redirect:/produit_interface_employee";

    }


    //***********************************************************************//

    @PostMapping("/UpdateProduit")
    public String updateProduit(@RequestParam("file") MultipartFile file,
                                @RequestParam("nom_produit") String nom_produit,
                                @RequestParam("titre") String titre,
                                @RequestParam("description") String description,
                                @RequestParam("code") int code,
                                @RequestParam("categorie") String categorie,
                                @RequestParam("emplacement") String emplacement,
                                @RequestParam("prix_unitaire") float prix,
                                @RequestParam("quantite") int quantite,
                                @RequestParam("etat_stock") String etat_stock,
                                @RequestParam("date_cree") String date_cree) throws ParseException {


        System.out.println("first date : " + date_cree);
        DateFormat formaDate = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = formaDate.parse(date_cree);
        System.out.println(" date after parser: " + date_cree);
        String date = formaDate.format(d);
        System.out.println(" date after format: " + date_cree);


        java.sql.Date sqld = java.sql.Date.valueOf(date);


        produiService.updateProduit(file, nom_produit, titre,
                description, code, categorie, emplacement, prix, quantite,
                etat_stock, sqld);

        return "redirect:/produit_interface_employee";

    }





}
