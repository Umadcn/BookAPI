package com.example.bookapi.dto;

import lombok.*;

@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
}