package com.example.demo.emails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails {

    private String emailSender;
    private String subject;
    private String message;
    private String recipient;
}
