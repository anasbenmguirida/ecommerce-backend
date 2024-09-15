package com.example.demo.emails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.commande.Commande;
import com.example.demo.commande.CommandeService;
import com.example.demo.users.User;
import com.example.demo.users.UserRepository;
import com.example.demo.users.UserService;
import java.util.Random;

import jakarta.websocket.ClientEndpointConfig.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Service
public class EmailService implements EmailInterface {

    private final JavaMailSender javaMailSender;
    private final CommandeService commandeService;
    private final UserRepository userRepository;

    public String sendSimpleEmail(EmailDetails emailDetails) {
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("anasbenmki@gmail.com");
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setText("confirmation message about your purchase ");
            mailMessage.setSubject("Moul tech purchase");

            // Sending the mail
            System.out.println(mailMessage);
            javaMailSender.send(mailMessage);
            int userId = this.userRepository.findUserIdByEmail(emailDetails.getRecipient());
            // generate a random value for the commande's id
            Random rand = new Random();
            int random = rand.nextInt(10000);

            Commande commande = new Commande(random, userId);

            this.commandeService.saveCommande(commande);
            System.out.println("*********the commande************** : " + commande);

            return "Mail Sent Successfully...";

        } catch (Exception e) {
            return "Error while Sending Mail : " + e;
        }
    }

}
