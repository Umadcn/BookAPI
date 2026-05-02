package com.example.bookapi.controller;

import com.example.bookapi.dto.*;
import com.example.bookapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

private final AuthService authService;

    @PostMapping("/login")
public AuthResponse login(@RequestBody AuthRequest request) {
    return authService.login(request);
}

}