package com.example.bookmanagement.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class BookPatchRequest {

    @Size(min = 1, message = "Title cannot be empty")
    private String title;

    @Size(min = 1, message = "Author cannot be empty")
    private String author;

    @Size(min = 1, message = "ISBN cannot be empty")
    private String isbn;

    private LocalDate publishedDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}