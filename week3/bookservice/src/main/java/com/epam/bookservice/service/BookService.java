package com.epam.bookservice.service;

import com.epam.bookservice.dao.BookRepository;
import com.epam.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> booksList = new ArrayList<>();
         bookRepository.findAll().forEach(books -> booksList.add(books));
         return booksList;
    }

    public Book saveBook(Book books){
        return bookRepository.save(books);
    }

    public void deleteBook(Long id){
         bookRepository.deleteById(id);
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);

    }

    public void updateBook(Book books){
        bookRepository.save(books);
    }

}


