package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.commande.Commande;
import com.example.demo.commande.CommandeService;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository ur;
    private final CommandeService cs;

    @Autowired
    public UserService(UserRepository ur, CommandeService commandeService) {
        this.ur = ur;
        this.cs = commandeService;
    }

    public String saveUser(User user) {
        ur.save(user);
        return "User saved succesfully";
    }

    public String saveUserCommande(String email) {

        Optional<User> user = ur.findByEmail(email);
        System.out.println(" the user : " + user);
        /*
         * Commande commande = new Commande(101, 1);
         * this.cs.saveCommande(commande);
         * System.out.println("*********the commande************** : " + commande);
         */
        return "commande deatils saved succesfully ";

    }

    public List<User> getUsers() {
        return ur.findAll();
    }

    public Optional<User> getUserById(int id) {
        return this.ur.findById(id);
    }

}
