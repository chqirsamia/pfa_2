package com.inventaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.inventaire.service.CommandeService;
import com.inventaire.service.ProduitService;

@Controller
public class CommandeController {
	@Autowired
    CommandeService commandeService;
	
	 

}
