package com.inventaire.RestController;

import com.inventaire.model.Command;
import com.inventaire.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandRestController {

    @Autowired
    CommandService commandService;

    @GetMapping("/addCommand/{id}")
    public Command addCommand(Model model,@PathVariable("id") Long id){
        return commandService.addCommande(id);
    }
}
