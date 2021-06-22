package com.inventaire.RestController;

import com.inventaire.model.Categorie;
import com.inventaire.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieRestController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("/findCategorieById_Categorie/{id_categorie}")
    public Categorie findCategorieById_Categorie(@PathVariable int id_categorie){
        return categorieService.findCategorieById_Categorie(id_categorie);
    }

}
