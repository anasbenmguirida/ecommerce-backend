package com.example.demo.emails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.users.User;
import com.example.demo.users.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Service
public class EmailService implements EmailInterface {

    private final JavaMailSender javaMailSender;
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
            return "Mail Sent Successfully...";
        } catch (Exception e) {
            return "Error while Sending Mail : " + e;
        }
    }

}
