package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.book.Book;
import org.example.repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookRepoAdapter implements BookCrudRepo {

    private final BooksRepo jpaRepository;

    @Override
    public Book save(Book book) {
        return jpaRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Collection<Book> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}