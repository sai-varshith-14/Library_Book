package com.platform.library.controller;

import com.platform.library.entity.BookEntity;
import com.platform.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<?> upload(@RequestBody BookEntity book){
        try {
            BookEntity savedBook = bookService.create(book);
            // Returns 201 Created on success
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        } catch (RuntimeException e) {
            // Returns 409 Conflict (or 400 Bad Request) with a clear message
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks(){
        try{
            List<BookEntity> booksAvailable = bookService.getAllBooks();
            return ResponseEntity.status(OK).body(booksAvailable);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){

        try{
            BookEntity bookAvailable = bookService.getById(id);
            return ResponseEntity.status(OK).body(bookAvailable);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable Long id, @RequestBody BookEntity updateBook){
        try{
            BookEntity updatedBook = bookService.updateById(id,updateBook);
            return ResponseEntity.status(OK).body(updatedBook);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        if(bookService.deleteBookById(id)){
            return ResponseEntity.ok("Book has been Successfully Deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Book has been found with the given credentials. Please Re-Check");
    }
}
