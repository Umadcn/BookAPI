package com.example.bookapi.util;

import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.dto.BookResponse;
import com.example.bookapi.entity.Book;

public class MapperUtil {

    private MapperUtil() {} 

    public static Book toEntity(BookRequest request) {
        return new Book(
                request.getIsbn(),
                request.getTitle(),
                request.getAuthor(),
                request.getPublicationYear()
        );
    }

    public static BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear()
        );
    }
}