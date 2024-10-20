package com.example.demo.CommandeDetails;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Data
@AllArgsConstructor
public class CommandeDetailsController {
    private final CommDetailsService commDetailsService ; 
  

    @PostMapping("/api/save-details")
    public  String saveDetails(@RequestBody ArrayList<CommandeDetails> commandeDetails) {
        return this.commDetailsService.saveCommande(commandeDetails) ; 
    }
    @GetMapping("/api/get-commandes")
    public List<CommandeDetails> getDetails(){
        return this.commDetailsService.getCommandes() ; 
    }
    @GetMapping("/api/get-commande/{id}")
    public List< CommandeDetails> getCommande(@PathVariable int id) {
        return this.commDetailsService.getUserCommandes(id) ;
    }
    @PostMapping("/api/change-state-app/{id}")
    public String changeStateToApproved(@PathVariable int id ){
        return this.commDetailsService.approveCommande(id) ; 
    }
    @PostMapping("/api/change-state-can/{id}")
    public String changeStateToCanceled(@PathVariable int id ){
        return this.commDetailsService.approveCommande(id) ; 
    }


}
