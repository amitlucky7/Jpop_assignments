package com.epam.bookservice.controller;

import com.epam.bookservice.model.Book;
import com.epam.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks()
    {
        List<Book> booksList = bookService.getAllBooks();
        if(booksList.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(booksList,HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> saveBook(@RequestBody Book books) {
        try {
            Book book = bookService.saveBook(books);
            return new ResponseEntity<>(book,HttpStatus.CREATED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable("bookId") Long bookId) {
        Optional<Book> bookData =  bookService.getBookById(bookId);
        if(bookData.isPresent()){
            return new ResponseEntity<>(bookData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PutMapping("books/{bookId}")
    public ResponseEntity<Book> updateBookDetails(@PathVariable("bookId")Long bookId,@RequestBody Book book) {
        Optional<Book> bookData = bookService.getBookById(bookId);
        if(bookData.isPresent()) {
            Book oldData = bookData.get();
            oldData.setBookName(book.getBookName());
            oldData.setAuthorName(book.getAuthorName());
            oldData.setBookDescription(book.getBookDescription());
            oldData.setCreatedBy(book.getCreatedBy());
            oldData.setCreatedOn(book.getCreatedOn());
            oldData.setLastModifiedBy(book.getLastModifiedBy());
            oldData.setLastModifiedOn(book.getLastModifiedOn());
            return new ResponseEntity<>(bookService.saveBook(oldData), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(bookData.get(),HttpStatus.OK);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable("id") Long id) {
        try{
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}


