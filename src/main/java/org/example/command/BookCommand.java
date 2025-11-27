package org.example.command;

import org.example.book.Book;
import org.example.service.BookService;


public class BookCommand implements Command<Book> {
    private final BookService bookService;
    private final Book bookData;

    public BookCommand(BookService bookService, Book bookData) {
        this.bookService = bookService;
        this.bookData = bookData;
    }

    @Override
    public Book execute() {

        System.out.println("LOG: CreateBookCommand executare sincron");
        return bookService.create(bookData);
    }
}