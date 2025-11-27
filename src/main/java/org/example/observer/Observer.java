package org.example.observer;

import org.example.book.Book;

public interface Observer {
    void update(Book book);
}