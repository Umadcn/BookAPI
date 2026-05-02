package com.example.bookapi.service.impl;

import com.example.bookapi.dto.*;
import com.example.bookapi.entity.Book;
import com.example.bookapi.exception.ResourceNotFoundException;
import com.example.bookapi.repository.BookRepository;
import com.example.bookapi.service.BookService;
import com.example.bookapi.util.MapperUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public BookResponse addBook(BookRequest request) {
        Book book = MapperUtil.toEntity(request);
        return MapperUtil.toResponse(repository.save(book));
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(MapperUtil::toResponse)
                .toList();
    }

    @Override
    public BookResponse getBookByIsbn(String isbn) {
        Book book = repository.findById(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        return MapperUtil.toResponse(book);
    }

    @Override
    public BookResponse updateBook(String isbn, BookRequest request) {
        Book book = repository.findById(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublicationYear(request.getPublicationYear());

        return MapperUtil.toResponse(repository.save(book));
    }

    @Override
    public void deleteBook(String isbn) {

        Book book = repository.findById(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        repository.delete(book);
    }

}