package com.example.demo.config;

import org.springframework.context.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.users.UserRepository;

@Configuration

public class ApplicationConfig {
    private UserRepository ur;

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> ur.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
