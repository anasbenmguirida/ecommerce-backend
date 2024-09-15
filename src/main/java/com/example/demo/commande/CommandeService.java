package com.example.demo.commande;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    public String saveCommande(Commande commande) {
        this.commandeRepository.save(commande);
        return "commande saved succesfully ";
    }

    public List<Commande> getCommandes() {
        return this.commandeRepository.findAll();
    }
}
