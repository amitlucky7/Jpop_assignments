package com.epam.bookservice.service;

import com.epam.bookservice.dao.BookRepository;
import com.epam.bookservice.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Books> getAllBooks(){
        List<Books> booksList = new ArrayList<>();
         bookRepository.findAll().forEach(books -> booksList.add(books));
         return booksList;
    }

    public void saveBook(Books books){
        bookRepository.save(books);
    }

    public void deleteBook(int id){
         bookRepository.deleteById(id);
    }

    public Optional<Books> getBookById(int id){
        return bookRepository.findById(id);

    }

    public void updateBook(Books books){
        bookRepository.save(books);
    }

}


