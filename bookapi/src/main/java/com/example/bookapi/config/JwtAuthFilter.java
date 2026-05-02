package com.example.bookapi.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthFilter implements Filter {

    @Override
public void doFilter(ServletRequest request,
                     ServletResponse response,
                     FilterChain chain)
        throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;

    String path = req.getRequestURI();

    if (path.startsWith("/auth")) {
        chain.doFilter(request, response);
        return;
    }

    String header = req.getHeader("Authorization");

    if (header == null || !header.startsWith("Bearer ")) {
        System.out.println("No token found, but allowing request");
    } else {
        System.out.println("Token received: " + header);
    }

    chain.doFilter(request, response);
}
}