package com.example.demo.emails;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
public class MailController {
    private final EmailService emailService;

    @PostMapping("/api/send-email")
    public String sendEmailToUser(@RequestBody EmailDetails emailDetails) {
        return this.emailService.sendSimpleEmail(emailDetails);
    }
}
