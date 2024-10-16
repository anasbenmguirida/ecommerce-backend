package com.example.demo.commande;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.User;
import com.example.demo.users.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;
    private UserService userService ; 

    @GetMapping("/api/commandes")
    public List<Commande> getAllCommandes() {
        return this.commandeService.getCommandes();
    }

    @GetMapping("/api/people-commandes")
    public ArrayList<User> commandePeople() {
        return this.commandeService.commandePeople();
    }
    
    
    @PostMapping("/api/save-commande")
    public String  saveCommande(@RequestParam String email) {
    return this.userService.saveUserCommande(email) ; 
    }
     

    
    


}
