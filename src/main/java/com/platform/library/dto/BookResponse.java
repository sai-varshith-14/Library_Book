package com.platform.library.dto;

import java.time.LocalDateTime;

public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer publishedYear;
    private boolean available;
    private LocalDateTime createdAt;

    public BookResponse() {
    }

    public BookResponse(String author, boolean available, LocalDateTime createdAt, Long id, String isbn, Integer publishedYear, String title) {
        this.author = author;
        this.available = available;
        this.createdAt = createdAt;
        this.id = id;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
