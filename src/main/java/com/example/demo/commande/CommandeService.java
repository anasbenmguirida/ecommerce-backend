package com.example.demo.commande;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.users.User;
import com.example.demo.users.UserRepository;
import com.example.demo.users.UserService;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;
    private UserRepository userRepository;

    public String saveCommande(Commande commande) {
        this.commandeRepository.save(commande);
        return "commande saved succesfully ";
    }

    public List<Commande> getCommandes() {
        return this.commandeRepository.findAll();
    }

    public void commandePeople() {
        List<Commande> listeCommande = this.getCommandes();
        List<String> listeEmails;
        for (Commande commande : listeCommande) {
            Optional<User> user = this.userRepository.findById(commande.getUserID());
            System.out.println("User : " + user);

        }
    }
}
