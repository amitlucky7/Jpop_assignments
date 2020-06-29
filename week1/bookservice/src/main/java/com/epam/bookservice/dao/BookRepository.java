package com.epam.bookservice.dao;

import com.epam.bookservice.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books,Integer> {
}
