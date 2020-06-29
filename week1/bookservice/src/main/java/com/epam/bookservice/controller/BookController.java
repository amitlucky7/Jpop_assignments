package com.epam.bookservice.controller;

import com.epam.bookservice.model.Books;
import com.epam.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/v1/api")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public int saveBook(@RequestBody Books books){
        bookService.saveBook(books);
        return books.getBookId();
    }

    @GetMapping("/books/{bookId}")
    public Optional<Books> getBookById(@PathVariable("bookId")int bookId){
        return bookService.getBookById(bookId);
    }

    @PutMapping("books")
    public void updateBookDetails(Books books){
         bookService.updateBook(books);
    }

    @DeleteMapping("books/{id}")
    public void deleteBookById(@PathVariable("id") int id){
        bookService.deleteBook(id);
    }

}


