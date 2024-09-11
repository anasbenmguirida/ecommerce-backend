package com.example.demo.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtService;
import com.example.demo.users.User;
import com.example.demo.users.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {
                User user = User.builder()
                                .name(request.getName())
                                .email(request.getEmail())
                                .address(request.getAddress())
                                .phone(request.getPhone())
                                .build();
                var savedUser = userRepository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .accessToken(jwtToken).build();
        }

        // the Login
        public AuthenticationResponse login(LoginRequest request) {
                System.out.println(request.getEmail());

                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));

                User user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow();
                if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                        var jwtToken = jwtService.generateToken(user);
                        return AuthenticationResponse.builder()
                                        .accessToken(jwtToken).build();
                } else {
                        return null;
                }

        }
}
