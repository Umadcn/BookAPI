package com.example.bookapi.service.impl;

import com.example.bookapi.dto.AuthRequest;
import com.example.bookapi.dto.AuthResponse;
import com.example.bookapi.entity.User;
import com.example.bookapi.repository.UserRepository;
import com.example.bookapi.service.AuthService;
import com.example.bookapi.util.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    @Override
    public AuthResponse login(AuthRequest request) {

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"));

        if (!user.getPassword()
                .equals(request.getPassword())) {

            throw new RuntimeException(
                    "Invalid password");
        }

        String token = jwtUtil
                .generateToken(user.getUsername());

        return new AuthResponse(token);
    }

    @Override
    public String register(AuthRequest request) {

        boolean userExists =
                userRepository
                        .findByUsername(
                                request.getUsername())
                        .isPresent();

        if (userExists) {

            throw new RuntimeException(
                    "Username already exists");
        }

        User user = new User();

        user.setUsername(request.getUsername());

        user.setPassword(request.getPassword());

        userRepository.save(user);

        return "User Registered Successfully";
    }
}