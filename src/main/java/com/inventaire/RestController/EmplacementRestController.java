package com.inventaire.RestController;


import com.inventaire.model.Emplacement;
import com.inventaire.service.EmplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmplacementRestController {

    @Autowired
    EmplacementService emplacementService;

    @GetMapping("/findEmplacementById_Emplacement/{id_emplacement}")
    public Emplacement findEmplacementById_Emplacement(@PathVariable int id_emplacement){
        return emplacementService.findEmplacementById_Emplacement(id_emplacement);
    }
}
