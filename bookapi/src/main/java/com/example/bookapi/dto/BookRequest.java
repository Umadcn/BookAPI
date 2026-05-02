package com.example.bookapi.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class BookRequest {

    @NotBlank
    private String isbn;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @Min(1000)
    private int publicationYear;
}