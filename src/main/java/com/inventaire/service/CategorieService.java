package com.inventaire.service;

import com.inventaire.dao.CategorieDAO;
import com.inventaire.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieService {

    @Autowired
    CategorieDAO categorieDAO;

    public List<Categorie> findAllCategorie(){
        return categorieDAO.findAll();
    }

    public List<String> categoriesNom(){
        List<Categorie> categorie = categorieDAO.findAll();
        List<String> categories= new ArrayList<>();

        for(int i=0;i< categorie.size();i++){
            categories.add(categorie.get(i).getNom_categorie());
        }
        return categories;
    }

    public Categorie findCategorieById_Categorie(int id_categorie){
        return categorieDAO.findCategorieById_Categorie(id_categorie);
    }

}
