package com.example.bookapi.service;

import com.example.bookapi.dto.*;

import java.util.List;

public interface BookService {
    BookResponse addBook(BookRequest request);
    List<BookResponse> getAllBooks();
    BookResponse getBookByIsbn(String isbn);
    BookResponse updateBook(String isbn, BookRequest request);
    void deleteBook(String isbn);
}