package com.example.demo.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtservice = new JwtService();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String AuthenticationHeader = request.getHeader("Authorization");
        final String JWTtoken;
        final String email;
        if (AuthenticationHeader == null
                || !AuthenticationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        JWTtoken = AuthenticationHeader.substring(7); // 7seb bearer + space ?
        // extract the email from the JWT token
        email = jwtservice.extractEmail(JWTtoken);

    }

}
