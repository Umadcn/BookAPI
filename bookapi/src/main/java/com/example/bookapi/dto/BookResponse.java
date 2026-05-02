package com.example.bookapi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class BookResponse {

    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
}