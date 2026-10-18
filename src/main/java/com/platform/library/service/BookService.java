package com.platform.library.service;

import com.platform.library.entity.BookEntity;
import com.platform.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity create(BookEntity book) {
        if(bookRepository.existsByIsbn(book.getIsbn())){
            throw new RuntimeException("A book with ISBN " + book.getIsbn() + " already exists!");
        }
        if(book.getPublishedYear() > 2026){
            throw new RuntimeException("Published Year is Invalid");
        }
        if(book.getPublishedYear() == null || book.getIsbn() == null || book.getAuthor() == null || book.getTitle() == null){
            throw new RuntimeException("Invalid Details, Fill fill in all the required details");
//            check this once later by re-creating the database
        }
        return bookRepository.save(book);
    }


    public List<BookEntity> getAllBooks() {
        if(bookRepository.count() == 0){
            throw new RuntimeException("There are no books present in the Library");
        }
        return bookRepository.findAll();
    }

    public BookEntity getById(Long id) {
        BookEntity dbBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return dbBook;
    }


    public BookEntity updateById(Long id, BookEntity updateBook) {
        BookEntity updatedBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No Such Book exists in the library"));

        updatedBook.setAuthor(updateBook.getAuthor());
        updatedBook.setAvailable(updateBook.isAvailable());
        updatedBook.setIsbn(updateBook.getIsbn());
        updatedBook.setPublishedYear(updateBook.getPublishedYear());
        updatedBook.setTitle(updateBook.getTitle());


        return bookRepository.save(updatedBook);
    }

    public boolean deleteBookById(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
