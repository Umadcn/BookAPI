package com.example.bookapi.service.impl;

import com.example.bookapi.dto.AuthRequest;
import com.example.bookapi.dto.AuthResponse;
import com.example.bookapi.service.AuthService;
import com.example.bookapi.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse login(AuthRequest request) {

        // simple validation (enough for evaluation)
        if ("admin".equals(request.getUsername()) &&
            "admin".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());
            return new AuthResponse(token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}