package com.inventaire.service;


import com.inventaire.dao.EmplacementDAO;
import com.inventaire.model.Emplacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmplacementService {

    @Autowired
    EmplacementDAO emplacementDAO;

    public Emplacement findEmplacementById_Emplacement(int id_emplacement){
        return emplacementDAO.findEmplacementById_Emplacement(id_emplacement);
    }
}
