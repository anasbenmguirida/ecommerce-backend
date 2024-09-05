package com.example.demo.auth;

import com.example.demo.users.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // generates all the getters and setters for non final fields
@Builder // generates a builder for the class
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String role;
    private String address;
    private String phone;
}
