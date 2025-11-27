package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookService {

    private final BookCrudRepo bookRepository;

    public Collection<Book> findAll() {
        System.out.println("LOG: BookService findall executat .");
        return bookRepository.findAll();
    }


    public Book findById(Long id) {
        System.out.println("LOG: BookService findbyid executat : " + id);
        return bookRepository.findById(id)
                .orElse(null);
    }


    public Book create(Book newBook) {
        Book savedBook = bookRepository.save(newBook);
        System.out.println("LOG: BookService create executat.\nBook ID: " + savedBook.getId());
        return savedBook;
    }

    public Book update(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setIsbn(updatedBook.getIsbn());
            System.out.println("LOG: BookService update executat " + id);
            return bookRepository.save(existingBook);
        }).orElseThrow(() -> new NoSuchElementException("Book invalid: " + id));
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
        System.out.println("LOG: BookService delete executat " + id);
    }
}