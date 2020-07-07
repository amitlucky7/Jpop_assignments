package com.epam.bookservice.dao;

import com.epam.bookservice.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
