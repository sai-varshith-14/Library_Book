package com.platform.library.service;

import com.platform.library.dto.BookRequest;
import com.platform.library.dto.BookResponse;
import com.platform.library.entity.BookEntity;
import com.platform.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse create(BookRequest book) {
        if(bookRepository.existsByIsbn(book.getIsbn())){
            throw new RuntimeException("A book with ISBN " + book.getIsbn() + " already exists!");
        }
        if(book.getPublishedYear() > 2026){
            throw new RuntimeException("Published Year is Invalid");
        }
        if(book.getPublishedYear() == null || book.getIsbn() == null || book.getAuthor() == null || book.getTitle() == null){
            throw new RuntimeException("Invalid Details, Fill in all the required details");
//            check this once later by re-creating the database
        }
        BookEntity savedBook = bookRepository.save(toEntity(book));
        return toBookResponse(savedBook);
    }


    public List<BookResponse> getAllBooks() {
        if(bookRepository.count() == 0){
            throw new RuntimeException("There are no books present in the Library");
        }
        List<BookEntity> allBooks = bookRepository.findAll();
        return allBooks.stream().map(this::toBookResponse).toList();

    }

    public BookResponse getById(Long id) {
        BookEntity dbBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return toBookResponse(dbBook);
    }


    public BookResponse updateById(Long id, BookRequest updateBook) {
        BookEntity updatedBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No Such Book exists in the library"));

        updatedBook.setAuthor(updateBook.getAuthor());
        updatedBook.setAvailable(updateBook.isAvailable());
        updatedBook.setIsbn(updateBook.getIsbn());
        updatedBook.setPublishedYear(updateBook.getPublishedYear());
        updatedBook.setTitle(updateBook.getTitle());

        bookRepository.save(updatedBook);
        return toBookResponse(updatedBook);
    }

    public boolean deleteBookById(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private BookEntity toEntity(BookRequest b){
        return new BookEntity(b.getTitle(),b.getAuthor(),b.getIsbn(), b.getPublishedYear(), b.isAvailable());
    }

    private BookResponse toBookResponse(BookEntity b){
        return new BookResponse(b.getAuthor(),b.isAvailable(),b.getCreatedAt(),b.getId(),b.getIsbn(),b.getPublishedYear(),b.getTitle());
    }

}
