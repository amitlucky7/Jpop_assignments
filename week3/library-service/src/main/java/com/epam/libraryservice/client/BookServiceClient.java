package com.epam.libraryservice.client;

import com.epam.libraryservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value="bookService",url="http://localhost:9011/book-service")
public interface BookServiceClient {

    @GetMapping("/books")
     public ResponseEntity<List<Book>> getAllBooks();


}
