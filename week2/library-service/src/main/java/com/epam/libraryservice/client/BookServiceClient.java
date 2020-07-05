package com.epam.libraryservice.client;

import com.epam.libraryservice.model.Books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="bookService",url="localhost:9001/bookService")
public interface BookServiceClient {

    @GetMapping("/books")
     public ResponseEntity<List<Books>> getAllBooks();

}
