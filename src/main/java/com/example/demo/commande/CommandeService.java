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
        List<User> listUsers;
        for (Commande commande : listeCommande) {
            // geting every user details by id => commande.getUserId
            int currentUserId = commande.getUserID();
            System.out.println("print this : " + this.userRepository.findById(currentUserId));
            /*
             * Optional<User> user = this.userRepository.findById(commande.getUserID());
             * if (user.isPresent()) {
             * User user1 = user.get();
             * // add the user to the list
             * System.out.println("user details : " + user1);
             * } else {
             * System.out.println("user not found ");
             * }
             */
        }
    }
}
