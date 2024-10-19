package com.example.demo.CommandeDetails;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Data
@AllArgsConstructor
public class CommandeDetailsController {
    private final CommDetailsService commDetailsService ; 
  

    @PostMapping("/api/save-details")
    public  String saveDetails(@RequestBody CommandeDetails commandeDetails) {
        return this.commDetailsService.saveCommande(commandeDetails) ; 
    }

}
