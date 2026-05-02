package com.example.bookapi.controller;

import com.example.bookapi.dto.*;
import com.example.bookapi.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest request) {
        return ResponseEntity.ok(service.addBook(request));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAll() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookResponse> getByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(service.getBookByIsbn(isbn));
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<BookResponse> update(@PathVariable String isbn,
                                               @Valid @RequestBody BookRequest request) {
        return ResponseEntity.ok(service.updateBook(isbn, request));
    }

    @DeleteMapping("/{isbn}")
public ResponseEntity<String> delete(@PathVariable String isbn) {
    service.deleteBook(isbn);
    return ResponseEntity.ok("Deleted successfully");
}
}