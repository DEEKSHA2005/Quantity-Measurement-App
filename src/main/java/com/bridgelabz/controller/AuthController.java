package com.bridgelabz.controller;

import com.bridgelabz.dto.AuthRequest;
import com.bridgelabz.dto.AuthResponse;
import com.bridgelabz.entity.User;
import com.bridgelabz.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        return authService.register(user);
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody AuthRequest request
    ) {

        return authService.login(request);
    }
}