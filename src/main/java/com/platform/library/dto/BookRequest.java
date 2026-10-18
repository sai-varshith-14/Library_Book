package com.platform.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class BookRequest {

    @NotBlank(message = "Enter a valid title of book")
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String isbn;

    @NotNull
    private Integer publishedYear;


    private boolean available;


    public BookRequest() {
    }

    public BookRequest(String author, boolean available, String isbn, Integer publishedYear, String title) {
        this.author = author;
        this.available = available;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
