package com.epam.libraryservice.controller;


import com.epam.libraryservice.client.BookServiceClient;
import com.epam.libraryservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    BookServiceClient client;

    @RequestMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        System.out.println("hello USer ");
        return client.getAllBooks();
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello USer";
    }


}



