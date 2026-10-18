package com.platform.library.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title", nullable = false, length = 255)
    private String title;

    @Column(name = "author_name", nullable = false, length = 255)
    private String author;

    @Column(name = "isbn_no", nullable = false, unique = true, length = 13)
    private String isbn;

    @Column(name = "year_of_publish", nullable = false)
    private Integer publishedYear;

    @Column(name = "available", nullable = false)
    private boolean available;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity(String author, boolean available, LocalDateTime createdAt, Long id, String isbn, Integer publishedYear, String title) {
        this.author = author;
        this.available = available;
        this.createdAt = createdAt;
        this.id = id;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.title = title;
    }

    public BookEntity() {

    }
}
