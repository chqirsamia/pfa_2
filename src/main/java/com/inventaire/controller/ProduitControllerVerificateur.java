package com.inventaire.controller;

import com.inventaire.dao.CategorieDAO;
import com.inventaire.dao.EmplacementDAO;
import com.inventaire.model.Produit;
import com.inventaire.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProduitControllerVerificateur {

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


    @GetMapping("/produit_interface_verificateur")
    public String getProduitInterfaceEmployee(Model model) {
        Produit produit = new Produit();
        model.addAttribute("produit", produit);
        model.addAttribute("chercherPar", chercherPar);
        model.addAttribute("trierPar", trierPar);
        model.addAttribute("produits", produiService.findAllProduit());
        model.addAttribute("categories", categorieDAO.findAll());
        model.addAttribute("emplacements", emplacementDAO.findAll());
        return "produit_interface_verificateur";
    }


    @GetMapping("/produits/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String fileName = "produits.csv";

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;
        response.setHeader(headerKey, headerValue);
        List<Produit> listProduits = produiService.findAllProduit();

        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Produit", "Titre", "Description", "Code",
                "Id Categorie", "Id Emplacement", "Prix Unitaire", "Quantite",
                "Etat du Stock", "Date de creation ", "Date de modification"};

        String[] nameMapping = {"nom_produit", "titre", "description", "code",
                "id_categorie", "id_emplacement", "prix_unitaire", "quantite",
                "etat_stock", "date_cree", "date_modifier"};
        csvBeanWriter.writeHeader(csvHeader);
        for (Produit produit : listProduits) {
            csvBeanWriter.write(produit, nameMapping);
        }
        csvBeanWriter.close();

    }

    @GetMapping("/export/produit/{id_produit}")
    public void exportToCSVProduit(HttpServletResponse response,@PathVariable int id_produit) throws IOException {
        response.setContentType("text/csv");
        String fileName = "produit"+id_produit+".csv";

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;
        response.setHeader(headerKey, headerValue);
        Produit p = produiService.findProduitById_produit(id_produit);

        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Produit", "Titre", "Description", "Code",
                "Id Categorie", "Id Emplacement", "Prix Unitaire", "Quantite",
                "Etat du Stock", "Date de creation ", "Date de modification"};

        String[] nameMapping = {"nom_produit", "titre", "description", "code",
                "id_categorie", "id_emplacement", "prix_unitaire", "quantite",
                "etat_stock", "date_cree", "date_modifier"};
        csvBeanWriter.writeHeader(csvHeader);
        csvBeanWriter.write(p, nameMapping);
        csvBeanWriter.close();

    }

}
