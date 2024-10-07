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
        // save user'id and generate new Commande
        int userID = ur.findUserIdByEmail(email);
        System.out.println("user" + userID);
        Commande commande = new Commande(101, userID);
        cs.saveCommande(commande);
        return "commande saved succesfully";
    }

    public List<User> getUsers() {
        return ur.findAll();
    }

    public String getUserById(int id) {
        Optional<User> user = this.ur.findById(id);
        return "user : "+ user ; 

    }

}
