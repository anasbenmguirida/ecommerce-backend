package com.example.demo.commande;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/api/commandes")
    public List<Commande> getAllCommandes() {
        return this.commandeService.getCommandes();
    }

    @GetMapping("/api/people-commandes")
    public void commandePeople() {
        this.commandeService.commandePeople();
    }

}
