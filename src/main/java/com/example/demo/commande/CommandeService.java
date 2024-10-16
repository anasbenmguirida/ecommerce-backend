package com.example.demo.commande;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    
    public  CommandeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String saveCommande(Commande commande) {
        this.commandeRepository.save(commande);
        return "commande saved succesfully ";
    }

    public List<Commande> getCommandes() {
        return this.commandeRepository.findAll();
    }

    public ArrayList<User> commandePeople() {
        List<Commande> listeCommande = this.getCommandes();
        ArrayList<User> listUsers = new ArrayList<User>();
        List<Integer> userIds = listeCommande.stream()
                .map(Commande::getUserID)
                .collect(Collectors.toList());
        List<User> users = this.userRepository.findAllById(userIds);
        listUsers.addAll(users);
        return listUsers;
}

   
        
            
             
        
    }

