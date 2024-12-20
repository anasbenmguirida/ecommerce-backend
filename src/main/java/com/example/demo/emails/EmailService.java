package com.example.demo.emails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.example.demo.users.User;
import com.example.demo.users.UserRepository;
import com.example.demo.users.UserService;
import java.util.Random;

import jakarta.websocket.ClientEndpointConfig.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Service
public class EmailService  {

    private final JavaMailSender javaMailSender;
    private final UserRepository userRepository;

    public String sendSimpleEmail(String recipient) {
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("anasbenmki@gmail.com");
            mailMessage.setTo(recipient);
            mailMessage.setText("confirmation message about your purchase \n Your order is Approved ! An agent  will contact you shortly by phone ");
            mailMessage.setSubject("Tech Store purchase");

            // Sending the mail
            System.out.println(mailMessage);
            javaMailSender.send(mailMessage);

            return "Mail Sent Successfully...";

        } catch (Exception e) {
            return "Error while Sending Mail : " + e;
        }
    }

    

}
