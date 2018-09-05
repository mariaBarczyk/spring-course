package com.mycompany.spring5webapp.repository;

import com.mycompany.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
