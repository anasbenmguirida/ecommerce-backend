package com.example.demo.CommandeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate ; 
import java.util.*;

@Service
public class CommDetailsService {
    @Autowired
    private CommandeDetailsRepo commandeDetailsRepo ; 

    public CommDetailsService(CommandeDetailsRepo commDetailsRepo){
        this.commandeDetailsRepo=commDetailsRepo ;  
    }

    public String saveCommande(ArrayList<CommandeDetails> commandeDetails){
        LocalDate  date = LocalDate.now();
        // create a new commandedetails
        // dir fbalk que user y9d ycommander bzaf d les produit a la fois machi ghi 1 !
        for(CommandeDetails commandeDetails2 : commandeDetails ){
        commandeDetails2.setDateReservation(date);
        commandeDetails2.setPrice(commandeDetails2.getPrice());
        commandeDetails2.setQuantity(commandeDetails2.getQuantity());
        commandeDetails2.setUserId(commandeDetails2.getUserId());
        commandeDetails2.setProductId(commandeDetails2.getProductId()); 
        this.commandeDetailsRepo.save(commandeDetails2) ; 
        }
        return "Commande saved succesfully : " + commandeDetails ;
    }
    
    // f dashboard dial admin group by the id !!!!!! 
    public List<CommandeDetails> getCommandes(){
        return this.commandeDetailsRepo.getAllCommandeDetails(); 
    }
    // les commandes dial wa7d l user specific
    public List<CommandeDetails> getUserCommandes(int id){
        return this.commandeDetailsRepo.findCommandeDetailsByUserId(id)  ; 
    }

}
