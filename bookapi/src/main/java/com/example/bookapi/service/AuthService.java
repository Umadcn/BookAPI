package com.example.bookapi.service;

import com.example.bookapi.dto.AuthRequest;
import com.example.bookapi.dto.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest request);

    String register(AuthRequest request);
}