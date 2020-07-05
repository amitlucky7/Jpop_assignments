package com.epam.bookservice.controller;

import com.epam.bookservice.model.Books;
import com.epam.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookService")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Books>> getAllBooks()
    {
        List<Books> booksList = bookService.getAllBooks();
        if(booksList.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(booksList,HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Books> saveBook(@RequestBody Books books) {
        try {
            Books book = bookService.saveBook(books);
            return new ResponseEntity<>(book,HttpStatus.CREATED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Books> getBookById(@PathVariable("bookId") int bookId) {
        Optional<Books> bookData =  bookService.getBookById(bookId);
        if(bookData.isPresent()){
            return new ResponseEntity<>(bookData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PutMapping("books/{bookId}")
    public ResponseEntity<Books> updateBookDetails(@PathVariable("bookId")Integer bookId,@RequestBody Books books) {
        Optional<Books> bookData = bookService.getBookById(bookId);
        if(bookData.isPresent()) {
            Books oldData = bookData.get();
            oldData.setAuthor(books.getAuthor());
            oldData.setTitle(books.getTitle());
            oldData.setPrice(books.getPrice());
            oldData.setUserId(books.getUserId());
            return new ResponseEntity<>(bookService.saveBook(oldData), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(bookData.get(),HttpStatus.OK);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable("id") int id) {
        try{
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}


