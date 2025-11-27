package org.example.observer;

import org.example.book.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksSubject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void add(Book book) {
        notifyObservers(book);
    }

    private void notifyObservers(Book book) {
        observers.forEach(observer -> observer.update(book));
    }
}