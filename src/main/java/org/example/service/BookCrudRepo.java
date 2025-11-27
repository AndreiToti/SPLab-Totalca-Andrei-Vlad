package org.example.service;

import org.example.book.Book;
import java.util.Collection;
import java.util.Optional;


public interface BookCrudRepo {
    Book save(Book book);
    Optional<Book> findById(Long id);
    Collection<Book> findAll();
    void deleteById(Long id);

}