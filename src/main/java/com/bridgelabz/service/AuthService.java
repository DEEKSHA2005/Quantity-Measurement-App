package com.bridgelabz.service;

import com.bridgelabz.dto.AuthRequest;
import com.bridgelabz.dto.AuthResponse;
import com.bridgelabz.entity.User;
import com.bridgelabz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    // REGISTER USER
    public String register(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // LOGIN USER
    public AuthResponse login(AuthRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email")
                );

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token =
                jwtService.generateToken(user.getEmail());

        return new AuthResponse(
                token,
                user.getEmail()
        );
    }
}