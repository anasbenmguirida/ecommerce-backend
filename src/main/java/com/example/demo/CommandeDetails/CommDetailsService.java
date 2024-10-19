package com.example.demo.CommandeDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate ; 

@Service
public class CommDetailsService {
    @Autowired
    private CommandeDetailsRepo commandeDetailsRepo ; 

    public CommDetailsService(CommandeDetailsRepo commDetailsRepo){
        this.commandeDetailsRepo=commDetailsRepo ;  
    }

    public String saveCommande(CommandeDetails commandeDetails){
        LocalDate  date = LocalDate.now();
        commandeDetails = new CommandeDetails(1, commandeDetails.getUserId(), commandeDetails.getProductId()
        , commandeDetails.getQuantity(), commandeDetails.getPrice(), date) ; 
        this.commandeDetailsRepo.save(commandeDetails) ; 
        return "Commande saved succesfully : " + commandeDetails ;
    }

}
