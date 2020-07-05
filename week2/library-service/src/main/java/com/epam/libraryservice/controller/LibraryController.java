package com.epam.libraryservice.controller;


import com.epam.libraryservice.client.BookServiceClient;
import com.epam.libraryservice.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    BookServiceClient client;

    @RequestMapping("/books")
    public ResponseEntity<List<Books>> getAllBooks(){
        return client.getAllBooks();
    }


}



